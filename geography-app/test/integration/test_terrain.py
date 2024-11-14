"""
This script performs integration tests for the terrain service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

""" 
Check that terrain features are returned
"""
def test_terrain():
    url = 'http://localhost:8084/geography/terrain?bounds=POLYGON((-3 53, -3 55, -2 55, -2 53, -3 53))&aboveHeight=0'
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()

    features = response_json['features']

    assert len(features) > 0
