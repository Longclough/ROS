# Performing api tests on the weather app

from fastapi.testclient import TestClient
from http import HTTPStatus
from app.main import app
from shapely import from_wkt, from_geojson
import json

headers = {'Content-Type': 'application/json' }

service = 'http://localhost:8085/weather/get-bad-weather?'
bounds_wkt = 'POLYGON((-2.8 53.2, -2.2 53.2, -2.2 53.8, -2.8 53.8, -2.8 53.2))'
bounds = 'bounds=' + bounds_wkt

# checking the app returns a response and has correct status code
def test_weather_results(): 

    client = TestClient(app)
    response = client.get(service + bounds, headers=headers)
           
    response_json = response.json()
    features = response_json['features']

    assert response.status_code == HTTPStatus.OK
    assert len(features) > 0


# checking app returns error when invalid bounds 
def test_weather_invalid_bounds(): 

    client = TestClient(app)
    response = client.get(service + 'bounds=POLYGON((-2.8, -2.2 53.2, -2.2 53.8, -2.8 53.8, -2.8 53.2))', headers=headers)

    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

# checking app returns error when no bounds presented
def test_weather_no_bounds(): 

    client = TestClient(app)
    response = client.get(service, headers=headers)

    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

# testing filtering - checking features intersect bounds provided
def test_weather_filter(): 
     
    client = TestClient(app)
    response = client.get(service + bounds, headers=headers)

    response_json = response.json()    
    features = response_json['features']
    bounds_geom = from_wkt(bounds_wkt)
    
    for feature in features:
        feature_geom = from_geojson(json.dumps(feature))
        assert feature_geom.intersects(bounds_geom)
