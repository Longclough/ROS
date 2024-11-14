"""
This script performs integration tests for the airspace service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

""" 
Check that airspace features are returned
"""
def test_airspace():
    url = 'http://localhost:8083/environment-infrastructure/airspace?bounds=POLYGON((-3 53, -3 55, -2 55, -2 53, -3 53))'
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()

    features = response_json['features']

    assert len(features) > 0
