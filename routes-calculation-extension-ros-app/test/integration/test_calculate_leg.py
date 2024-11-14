"""
This script performs integration tests for the calculate_leg service
"""

from http import HTTPStatus
import requests
import json

""" 
Check that routepoints are returned
"""
def test_calculate_leg():
    url = 'http://localhost:8081/routes-calculation-extension/calculate-leg'
    headers = {'Content-Type': 'application/json' } 
    test_data_file = open('test/integration/test.json')
    test_data_json = json.load(test_data_file)
     
    response = requests.get(url, headers=headers, data=json.dumps(test_data_json, indent=4))       
    
    assert response.status_code == HTTPStatus.OK
   
    response_json = response.json()    

    assert len(response_json) > 1

    routepoint = response_json[len(response_json) -1]
    end = test_data_json['end']
    
    assert routepoint['latitude'] == end['latitude']
    assert routepoint['longitude'] == end['longitude']
    assert routepoint['altitude'] == end['altitude']