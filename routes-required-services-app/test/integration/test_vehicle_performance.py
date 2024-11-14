"""
This script performs integration tests for the vehicle-performance service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

""" 
Check that vehicle performance data are returned
"""
def test_vehicle_performance():
    url = 'http://localhost:8082/routes-required-services/vehicle-performance'
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()

    assert response_json['maximum_altitude'] > 0
