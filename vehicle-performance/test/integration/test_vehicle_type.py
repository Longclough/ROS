"""
This script performs integration tests for the vehicle_type service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

vehicle_type = 'Spitfire'

""" 
Check that vehicle type parameters are returned
"""
def test_vehicle_type():
    url = 'http://localhost:8086/vehicle_performance/v2/vehicle_type/get-params?vehicle_type=' + vehicle_type
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()
    
    id = response_json['id']
    assert id == vehicle_type

    params = response_json['params']
    assert len(params) > 0