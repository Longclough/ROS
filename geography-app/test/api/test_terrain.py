"""
This script performs api tests for the terrain service
"""

from fastapi.testclient import TestClient
from http import HTTPStatus
from shapely import from_wkt, from_geojson
from app.main import app
import json

headers = {'Content-Type': 'application/json' } 

service = 'http://localhost:8084/geography/terrain?'
bounds_wkt = 'POLYGON((-3 53, -3 55, -2 55, -2 53, -3 53))'
bounds = 'bounds=' + bounds_wkt
height = 'aboveHeight=100'

"""
Check results are returned and intersect the supplied bounds
"""
def test_terrain_results():
    client = TestClient(app)

    response = client.get(service + bounds + '&' + height, headers=headers)
    
    assert response.status_code == HTTPStatus.OK

    response_json = response.json()    
    features = response_json['features']

    assert len(features) > 0

    bounds_geom = from_wkt(bounds_wkt)    
    
    for feature in features:
        feature_geom = from_geojson(json.dumps(feature))
        assert feature_geom.intersects(bounds_geom)

""" 
Check that not providing the aboveHeight parameter gives an error 
"""
def test_terrain_no_height():
    client = TestClient(app)

    response = client.get(service + bounds, headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

"""
Check that providing a non-numeric aboveHeight parameter gives an error
"""
def test_terrain_invalid_height():
    client = TestClient(app)

    response = client.get(service + bounds + '&aboveHeight=high', headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

""" 
Check that not providing the bounds parameter gives an error 
"""
def test_terrain_no_bounds():
    client = TestClient(app)

    response = client.get(service + height, headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

""" 
Check that providing a non-wkt bounds parameter gives an error 
"""
def test_terrain_invalid_bounds():
    client = TestClient(app)

    response = client.get(service + 'bounds=POGYLON((-3 53, -3 55, -2 55, -2 53, -3 53))&' + height, headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

""" 
Check that providing a bounds parameter that intersects an area with no data gives an error 
"""
def test_terrain_no_data_bounds():
    client = TestClient(app)

    response = client.get(service + 'bounds=POLYGON((-3 -53, -3 -55, -2 -55, -2 -53, -3 -53))&' + height, headers=headers)
    
    assert response.status_code == HTTPStatus.INTERNAL_SERVER_ERROR