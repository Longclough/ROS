"""
This script performs api tests for the vehicle-performance service.
"""

from http import HTTPStatus
from fastapi.testclient import TestClient
import responses
import os

os.environ["MQTT_BROKER"] = "127.0.0.1"
os.environ["MQTT_PORT"] = "1888"

vehicle_performance_url = "http://vehicle-performance-app:8080/vehicle_performance/get-params"
vehicle_performance_data = '{"type": "VehicleData","id": "Spitfire","params": [{"type": "max_altitude", "value": 50000},{"type": "cruise_altitude", "value": 30000},{"type": "max_airspeed", "value": 1000}]}'

headers = {'Content-Type': 'application/json' } 

""" 
Check that the required services are called
"""
@responses.activate
def test_vehicle_performance_required_services():
    from app.main import app

    client = TestClient(app)
    
    responses.reset
    responses.add(responses.GET, vehicle_performance_url, status=HTTPStatus.OK, body=vehicle_performance_data)

    client.get('http://localhost:8082/routes-required-services/vehicle-performance', headers=headers)

    vehicle_performance_calls = []

    for call in responses.calls:
        if call.request.url.startswith(vehicle_performance_url):
            vehicle_performance_calls.append(call)        

    assert len(vehicle_performance_calls) == 1

""" 
Check that vehicle perfomance data are returned
"""
@responses.activate
def test_vehicle_performance_results():
    from app.main import app

    client = TestClient(app)

    responses.reset
    responses.add(responses.GET, vehicle_performance_url, status=HTTPStatus.OK, body=vehicle_performance_data)

    response = client.get('http://localhost:8082/routes-required-services/vehicle-performance', headers=headers)
    
    assert response.status_code == HTTPStatus.OK

    response_json = response.json() 

    assert response_json['maximum_altitude'] == 50000