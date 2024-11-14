"""
This script performs integration tests for the route service.
The PYRAMIDRoutingApplication system must be running on localhost.
"""

from http import HTTPStatus
import requests

""" 
Check that the route is accepted
"""
def test_route():
    url = 'http://localhost:8082/routes-required-services/route'
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.post(url, headers=headers, data='{"routepoints":[]}')       
    
    assert response.status_code == HTTPStatus.OK
