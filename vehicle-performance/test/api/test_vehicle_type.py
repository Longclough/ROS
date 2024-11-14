"""
This script performs api tests for the vehicle_type service
"""

from fastapi.testclient import TestClient
from http import HTTPStatus
from app.main import app
import json

headers = {'Content-Type': 'application/json' } 

service = 'http://localhost:8086/vehicle_performance/v2/vehicle_type/get-params?'
vehicle_type = 'Spitfire'

"""
Check results are returned and contain some data.
"""
def test_vehicle_type_results():
    client = TestClient(app)
    
    response = client.get(service + 'vehicle_type=' + vehicle_type, headers=headers)
    
    assert response.status_code == HTTPStatus.OK

    response_json = response.json()    

    params = response_json['params']
    assert len(params) > 0

""" 
Check that not providing the vehicle_type parameter gives an error 
"""
def test_vehicle_type_no_value():
    client = TestClient(app)

    response = client.get(service, headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

"""
Check that requesting an unsupported vehicle type gives an error
"""
def test_vehicle_type_unsupported_type():
    client = TestClient(app)

    response = client.get(service + 'vehicle_type=Sausage', headers=headers)
    
    assert response.status_code == HTTPStatus.NO_CONTENT