"""
This script performs api tests for the vehicle service
"""

from fastapi.testclient import TestClient
from http import HTTPStatus
from app.main import app
import json

headers = {'Content-Type': 'application/json' } 

service = 'http://localhost:8086/vehicle_performance/v2/vehicle/get-params?'
vehicles = ['XH558', 'PM631']

"""
Check results are returned and contain correct data.
"""
def test_vehicle_results():
    client = TestClient(app)
    
    for v in vehicles:
        response = client.get(service + 'id=' + v, headers=headers)
        
        assert response.status_code == HTTPStatus.OK

        response_json = response.json()    
        id = response_json['id']
        assert id == v

        params = response_json['params']
        assert len(params) > 0

""" 
Check that not providing the id parameter gives an error 
"""
def test_vehicle_no_value():
    client = TestClient(app)

    response = client.get(service, headers=headers)
    
    assert response.status_code == HTTPStatus.UNPROCESSABLE_ENTITY

"""
Check that requesting an unsupported vehicle id gives an error
"""
def test_vehicle_unsupported_id():
    client = TestClient(app)

    response = client.get(service + 'id=Sausage', headers=headers)
    
    assert response.status_code == HTTPStatus.NO_CONTENT
