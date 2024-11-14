"""
This script performs integration tests for the spatial-constraints service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

""" 
Check that spatial constraints are returned
"""
def test_spatial_constraints():
    url = 'http://localhost:8082/routes-required-services/spatial-constraints?bounds=POLYGON((-3.1187686629275024 53.5839194907546, -3.1197930039982644 53.98548093094448, -2.9042069960017356 53.98548093094448, -2.9052313370724976 53.5839194907546, -3.1187686629275024 53.5839194907546))&height=100'
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()

    features = response_json['features']

    assert len(features) > 0
