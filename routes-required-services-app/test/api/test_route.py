"""
This script performs api tests for the route service.
"""

from http import HTTPStatus
from fastapi.testclient import TestClient
import testsupport.paho_test
from testsupport.broker import fake_broker
import os

os.environ["MQTT_BROKER"] = "127.0.0.1"
os.environ["MQTT_PORT"] = "1888"

route_data = '{"routepoint": []}'

""" 
Check that the posted route is published
"""
def test_route(fake_broker):
    from app.main import app

    fake_broker.start()
    fake_broker.receive_packet(1000)

    client = TestClient(app)
      
    headers = {'Content-Type': 'application/json' } 

    response = client.post('http://localhost:8082/routes-required-services/route', headers=headers, data=route_data)

    assert response.status_code == HTTPStatus.OK

    received_packet = fake_broker.receive_packet(1000)
    expected_packet = testsupport.paho_test.gen_publish("route", 0, payload=route_data, proto_ver=4)

    assert received_packet  # Check connection was not closed    
    assert received_packet == expected_packet