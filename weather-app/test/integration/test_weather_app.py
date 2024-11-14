# Performing integration tests for the weather app
# The PYRAMIDRoutingApplication system must be running on localhost.

import requests
from http import HTTPStatus

# check that weather features are successfully returned
def test_weather_app(): 
    url = 'http://localhost:8085/weather/get-bad-weather?bounds=POLYGON((-2.8 53.2, -2.2 53.2, -2.2 53.8, -2.8 53.8, -2.8 53.2))'
    headers = {'Content-Type': 'application/json' } 
     
    response = requests.get(url, headers=headers)       
    response_json = response.json()
    features = response_json['features']

    assert response.status_code == HTTPStatus.OK
    assert len(features) > 0



