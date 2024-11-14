"""
This script performs api tests for the calculate_leg service
"""

from http import HTTPStatus
from fastapi.testclient import TestClient
from shapely import LineString, from_geojson
import responses
import json
from app.main import app

test_data_path = 'test/api/test.json'#

spatial_constraints_url = "http://routes-required-services-app:8080/routes-required-services/spatial-constraints"
spatial_constraints_data = '{"type":"FeatureCollection","features":[{"geometry":{"coordinates":[[[-3.1,53.05],[-3.1,53.15],[-3,53.15],[-3,53.05],[-3.1,53.05]]],"type":"Polygon"},"type":"Feature","properties":{"name":"avoid me"}}]}'
no_route_spatial_constraints_data = '{"type":"FeatureCollection","features":[{"geometry":{"coordinates":[[[-3.1,53],[-3.1,53.2],[-3,53.2],[-3,53],[-3.1,53]]],"type":"Polygon"},"type":"Feature","properties":{"name":"avoid me"}}]}'

headers = {'Content-Type': 'application/json' } 
url = "/routes-calculation-extension/calculate-leg"

""" 
Check that required services are called
"""
@responses.activate
def test_calculate_leg_required_services():
    client = TestClient(app)

    test_data_file = open(test_data_path)
    test_data_json = json.load(test_data_file)

    responses.reset()
    responses.add(responses.GET, spatial_constraints_url, status=HTTPStatus.OK, body=spatial_constraints_data)

    client.get(url, headers=headers, data=json.dumps(test_data_json, indent=4))

    assert len(responses.calls) == 1
    assert responses.calls[0].request.url.startswith(spatial_constraints_url)       

""" 
Check that routepoints are returned and the route avoids spatial constraints
"""
@responses.activate
def test_calculate_leg_results():
    client = TestClient(app)

    test_data_file = open(test_data_path)
    test_data_json = json.load(test_data_file)

    responses.reset()
    responses.add(responses.GET, spatial_constraints_url, status=HTTPStatus.OK, body=spatial_constraints_data)

    response = client.get(url, headers=headers, data=json.dumps(test_data_json, indent=4))    
    
    response_json = response.json()    
    assert len(response_json) > 0

    routepoint = response_json[len(response_json)-1]
    end = test_data_json['end']
    assert routepoint['latitude'] == end['latitude']
    assert routepoint['longitude'] == end['longitude']
    assert routepoint['altitude'] == end['altitude']

    coords = []   

    for routepoint in response_json:
        coords.append((routepoint["longitude"], routepoint["latitude"]))         

    route_line = LineString(coords)
    spatial_constraints = from_geojson(spatial_constraints_data)

    assert not route_line.intersects(spatial_constraints)

""" 
Check that no routepoints are returned when spatial constraints prevent routing
"""
@responses.activate
def test_calculate_leg_no_route():
    client = TestClient(app)

    test_data_file = open(test_data_path)
    test_data_json = json.load(test_data_file)

    responses.reset()
    responses.add(responses.GET, spatial_constraints_url, status=HTTPStatus.OK, body=no_route_spatial_constraints_data)

    response = client.get(url, headers=headers, data=json.dumps(test_data_json, indent=4))    
    
    response_json = response.json()    
    assert len(response_json) == 0