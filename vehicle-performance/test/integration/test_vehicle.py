"""
This script performs integration tests for the vehicle service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

vehicle = 'XH558'

""" 
Check that vehicle parameters are returned
"""
def test_vehicle():
    url = 'http://localhost:8086/vehicle_performance/v2/vehicle_type/get-params?id=' + vehicle
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()
    
    id = response_json['id']
    assert id == vehicle

    params = response_json['params']
    assert len(params) > 0