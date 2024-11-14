from fastapi.testclient import TestClient
import responses
import json
from app.main import fast_api

spatial_constraints_url = "http://routes-required-services-app:8080/routes-required-services/spatial-constraints"
spatial_constraints_data = '{"type":"FeatureCollection","features":[]}'

vehicle_performance_url = "http://routes-required-services-app:8080/routes-required-services/vehicle-performance"
vehicle_performance_data = '{"maximum_altitude":1000}'

def load_test_data():
    test_data_file = open('test/test.json')
    return json.load(test_data_file)['requirement'][0]

def get_validator(test_data_json):
    headers = {'Content-Type': 'application/json' }
    client = TestClient(fast_api)
    response = client.get("/routes/validator", headers=headers, data=json.dumps(test_data_json, indent=4))
    return response

@responses.activate
def test_validator_required_services():
    responses.reset
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)

    test_data_json = load_test_data()
    get_validator(test_data_json)

    spatial_constraints_calls = []
    vehicle_performance_calls = []

    for call in responses.calls:
        if call.request.url.startswith(spatial_constraints_url):
            spatial_constraints_calls.append(call)
        elif call.request.url.startswith(vehicle_performance_url):
            vehicle_performance_calls.append(call)

    assert len(spatial_constraints_calls) == 1
    assert len(vehicle_performance_calls) == 1

@responses.activate
def test_validator_results():
    responses.reset
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)

    requirement = load_test_data()
    response = get_validator(requirement)

    assert response.status_code == 200

    achievability = response.json()

    assert achievability['requirement_id'] == requirement['id']
    assert achievability['achievable'] == True
    assert len(achievability['problems']) == 0

@responses.activate
def test_validator_spatial_validation_failed():
    conflicting_spatial_constraints_data = '{"type":"FeatureCollection","features":[{"type":"Feature", "properties": {}, "geometry":{"coordinates":[],"type":"Polygon"}}]}'

    responses.reset
    responses.add(responses.GET, spatial_constraints_url, status=200, body=conflicting_spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)

    requirement = load_test_data()
    response = get_validator(requirement)

    assert response.status_code == 200

    achievability = response.json()

    assert achievability['requirement_id'] == requirement['id']
    assert achievability['achievable'] == False
    assert len(achievability['problems']) == 1
    assert achievability['problems'][0]['description'].startswith('Requirement conflicts with spatial constraint:')

@responses.activate
def test_validator_performance_validation_failed():
    requirement = load_test_data()
    conflicting_altitude = requirement['altitude']-10
    conflicting_vehicle_performance_data = '{"maximum_altitude":' + str(conflicting_altitude) + '}'

    responses.reset
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=conflicting_vehicle_performance_data)

    requirement = load_test_data()
    response = get_validator(requirement)

    assert response.status_code == 200

    achievability = response.json()

    assert achievability['requirement_id'] == requirement['id']
    assert achievability['achievable'] == False
    assert len(achievability['problems']) == 1
    assert achievability['problems'][0]['description'].startswith('Requirement altitude')