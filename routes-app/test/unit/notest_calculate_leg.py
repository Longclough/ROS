import json
import app.main
import pytest
from app.routes_data_model import Requirement
import responses
from http import HTTPStatus

spatial_constraints_url = "http://routes-required-services-app:8080/routes-required-services/spatial-constraints"
spatial_constraints_data = json.loads('{"type":"FeatureCollection","features":[]}')

@pytest.mark.asyncio
@responses.activate
async def test_calculate_leg_required_services():   
    responses.reset 
    responses.add(responses.GET, spatial_constraints_url, json=spatial_constraints_data, status=HTTPStatus.OK)

    test_data_file = open('test/test.json')
    test_data_json = json.load(test_data_file)
    start = Requirement(**test_data_json['start'])
    end = Requirement(**test_data_json['end'])
     
    await app.main.calculate_leg(start, end)      

    assert len(responses.calls) == 1
    assert responses.calls[0].request.url.startswith(spatial_constraints_url)    

@pytest.mark.asyncio
@responses.activate
async def test_calculate_leg_required_results():    
    responses.reset
    responses.add(responses.GET, spatial_constraints_url, json=spatial_constraints_data, status=HTTPStatus.OK)

    test_data_file = open('test.json')
    test_data_json = json.load(test_data_file)
    start = Requirement(**test_data_json['start'])
    end = Requirement(**test_data_json['end'])
     
    result = await app.main.calculate_leg(start, end)           
    assert len(result) == 1
   
    routepoint = result[0]
    assert routepoint.latitude == end.latitude
    assert routepoint.longitude == end.longitude
    assert routepoint.altitude == end.altitude