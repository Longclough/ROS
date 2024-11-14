"""
This script performs api tests for the spatial-constraints service.
"""

from fastapi.testclient import TestClient
from http import HTTPStatus
import responses
import os

os.environ["MQTT_BROKER"] = "127.0.0.1"
os.environ["MQTT_PORT"] = "1888"

weather_url = "http://weather-app:8080/weather/get-bad-weather"
weather_data = '{"type":"FeatureCollection","features":[{"geometry":{"coordinates":[[[-3.106925,53.7973528],[-3.097725,53.8044972],[-3.083108389,53.797913],[-3.08310728296432,53.79791633373341],[-3.0867615867233824,53.79500272953432],[-3.089972587034232,53.79191155675681],[-3.0913681656245293,53.79034913708789],[-3.091369278,53.790345806],[-3.106925,53.7973528],[-3.106925,53.7973528]]],"type":"Polygon"},"type":"Feature","properties":{"name":"1"}}]}'

geography_url = "http://geography-app:8080/geography/terrain"
geography_data = '{"type":"FeatureCollection","features":[{"geometry":{"coordinates":[[[-3.106925,53.7973528],[-3.097725,53.8044972],[-3.083108389,53.797913],[-3.08310728296432,53.79791633373341],[-3.0867615867233824,53.79500272953432],[-3.089972587034232,53.79191155675681],[-3.0913681656245293,53.79034913708789],[-3.091369278,53.790345806],[-3.106925,53.7973528],[-3.106925,53.7973528]]],"type":"Polygon"},"type":"Feature","properties":{"name":"2"}}]}'

environment_infrastructure_url = "http://environment-infrastructure-app:8080/environment-infrastructure/airspace"
environment_infrastructure_data = '{"type":"FeatureCollection","features":[{"geometry":{"coordinates":[[[-3.106925,53.7973528],[-3.097725,53.8044972],[-3.083108389,53.797913],[-3.08310728296432,53.79791633373341],[-3.0867615867233824,53.79500272953432],[-3.089972587034232,53.79191155675681],[-3.0913681656245293,53.79034913708789],[-3.091369278,53.790345806],[-3.106925,53.7973528],[-3.106925,53.7973528]]],"type":"Polygon"},"type":"Feature","properties":{"name":"3"}}]}'

headers = {'Content-Type': 'application/json' }

""" 
Check that the required services are called
"""
@responses.activate
def test_spatial_constraints_required_services():
    from app.main import app

    client = TestClient(app)
      
    responses.reset
    responses.add(responses.GET, weather_url, status=HTTPStatus.OK, body=weather_data)
    responses.add(responses.GET, geography_url, status=HTTPStatus.OK, body=geography_data)
    responses.add(responses.GET, environment_infrastructure_url, status=HTTPStatus.OK, body=environment_infrastructure_data)

    client.get('http://localhost:8082/routes-required-services/spatial-constraints?bounds=POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))&height=100', headers=headers)

    weather_calls = []
    geography_calls = []
    environment_infrastructure_calls = []

    for call in responses.calls:
        if call.request.url.startswith(weather_url):
            weather_calls.append(call)
        elif call.request.url.startswith(geography_url):
            geography_calls.append(call)
        elif call.request.url.startswith(environment_infrastructure_url):
            environment_infrastructure_calls.append(call)

    assert len(weather_calls) == 1
    assert len(geography_calls) == 1
    assert len(environment_infrastructure_calls) == 1

""" 
Check that all features retrieved from required services are returned
"""
@responses.activate
def test_spatial_constraints_results():
    from app.main import app

    client = TestClient(app)

    responses.reset
    responses.add(responses.GET, weather_url, status=HTTPStatus.OK, body=weather_data)
    responses.add(responses.GET, geography_url, status=HTTPStatus.OK, body=geography_data)
    responses.add(responses.GET, environment_infrastructure_url, status=HTTPStatus.OK, body=environment_infrastructure_data)

    response = client.get('http://localhost:8082/routes-required-services/spatial-constraints?bounds=POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))&height=100', headers=headers)
    
    assert response.status_code == HTTPStatus.OK

    response_json = response.json()    
    features = response_json['features']

    assert len(features) == 3

    found_weather = False
    found_geography = False
    found_environment_infrastructure = False
    for feature in features:
        if feature['properties']['name'] == '1':
            found_weather = True
        elif feature['properties']['name'] == '2':
            found_geography = True
        elif feature['properties']['name'] == '3':
            found_environment_infrastructure = True

    assert found_weather
    assert found_geography
    assert found_environment_infrastructure

""" 
Check that not providing the height parameter gives an error 
"""
def test_spatial_constraints_no_height():
    from app.main import app

    client = TestClient(app)

    response = client.get('http://localhost:8082/routes-required-services/spatial-constraints?bounds=POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))', headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

"""
Check that providing a non-numeric height parameter gives an error
"""
def test_spatial_constraints_invalid_height():
    from app.main import app

    client = TestClient(app)

    response = client.get('http://localhost:8082/routes-required-services/spatial-constraints?bounds=POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))&height=high', headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

""" 
Check that not providing the bounds parameter gives an error 
"""
def test_spatial_constraints_no_bounds():
    from app.main import app

    client = TestClient(app)

    headers = {'Content-Type': 'application/json' } 

    response = client.get('http://localhost:8082/routes-required-services/spatial-constraints?height=100', headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

""" 
Check that providing a non-wkt bounds parameter gives an error 
"""
def test_spatial_constraints_invalid_bounds():
    from app.main import app

    client = TestClient(app)

    response = client.get('http://localhost:8082/routes-required-services/spatial-constraints?bounds=POGYLON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))&height=100', headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY