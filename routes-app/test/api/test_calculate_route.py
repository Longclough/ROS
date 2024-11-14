from fastapi.testclient import TestClient
import responses
import json
from app.main import fast_api

calculate_leg_url = "http://routes-calculation-extension-app:8080/routes-calculation-extension/calculate-leg"
calculate_leg_data = '[{"latitude":1, "longitude":2, "altitude":3}, {"latitude":4, "longitude":5, "altitude":6}]'

spatial_constraints_url = "http://routes-required-services-app:8080/routes-required-services/spatial-constraints"
spatial_constraints_data = '{"type":"FeatureCollection","features":[]}'

vehicle_performance_url = "http://routes-required-services-app:8080/routes-required-services/vehicle-performance"
vehicle_performance_data = '{"maximum_altitude":1000}'

route_url = "http://routes-required-services-app:8080/routes-required-services/route"
route_data = ''

def load_test_data():
    test_data_file = open('test/test.json')
    return json.load(test_data_file)

def post_calculate_route(test_data_json):
    headers = {'Content-Type': 'application/json' }
    client = TestClient(fast_api)
    response = client.post("/routes/calculate-route", headers=headers, data=json.dumps(test_data_json, indent=4))
    return response

@responses.activate
def test_calculate_route_required_services():
    responses.reset
    responses.add(responses.GET, calculate_leg_url, status=200, body=calculate_leg_data)
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)
    responses.add(responses.POST, route_url, status=200, body=route_data)

    test_data_json = load_test_data()
    post_calculate_route(test_data_json)

    requirements = test_data_json['requirement']

    calculation_extension_calls = []
    spatial_constraints_calls = []
    vehicle_performance_calls = []
    route_calls = []

    for call in responses.calls:
        print(call.request.url)
        if call.request.url.startswith(calculate_leg_url):
            calculation_extension_calls.append(call)
        elif call.request.url.startswith(spatial_constraints_url):
            spatial_constraints_calls.append(call)
        elif call.request.url.startswith(vehicle_performance_url):
            vehicle_performance_calls.append(call)
        elif call.request.url.startswith(route_url):
           route_calls.append(call)

    assert len(calculation_extension_calls) == len(requirements) - 1
    assert len(spatial_constraints_calls) == len(requirements)
    assert len(vehicle_performance_calls) == len(requirements)
    assert len(route_calls) == 1

@responses.activate
def test_calculate_route_results():
    responses.reset
    responses.add(responses.GET, calculate_leg_url, status=200, body=calculate_leg_data)
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)
    responses.add(responses.POST, route_url, status=200, body=route_data)

    test_data_json = load_test_data()
    response = post_calculate_route(test_data_json)

    assert response.status_code == 200

    response_json = response.json()

    requirements = test_data_json['requirement']

    requirement_ids = []
    for requirement in requirements:
        requirement_ids.append(requirement['id'])

    routepoints = response_json['routepoint']
    calculation_extension_routepoints = json.loads(calculate_leg_data)
    assert len(routepoints) == ((len(requirements)-1) * len(calculation_extension_routepoints)) + 1

    first_routepoint = routepoints[0]
    start = requirements[0]
    assert first_routepoint['latitude'] == start['latitude']
    assert first_routepoint['longitude'] == start['longitude']
    assert first_routepoint['altitude'] == start['altitude']

    satisfied_requirement_ids = []
    for routepoint in routepoints:
    	if 'satisfies_requirement_id' in routepoint:
            satisfied_requirement_ids.append(routepoint['satisfies_requirement_id'])

    assert requirement_ids == satisfied_requirement_ids

    for i in range(1, len(routepoints), len(calculation_extension_routepoints)):
        for j in range(0, len(calculation_extension_routepoints)):
            assert routepoints[i+j]['latitude'] == calculation_extension_routepoints[j]['latitude']
            assert routepoints[i+j]['longitude'] == calculation_extension_routepoints[j]['longitude']
            assert routepoints[i+j]['altitude'] == calculation_extension_routepoints[j]['altitude']

    achievabilities = response_json['achievability'].values()

    assert len(achievabilities) == len(requirements)

    achievability_requirement_ids = []

    for achievability in achievabilities:
        achievability_requirement_ids.append(achievability['requirement_id'])
        assert achievability['achievable'] == True
        assert len(achievability['problems']) == 0

    assert requirement_ids == achievability_requirement_ids

@responses.activate
def test_calculate_route_calculate_leg_failed():
    responses.reset
    responses.add(responses.GET, calculate_leg_url, status=200, body='[]')
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)
    responses.add(responses.POST, route_url, status=200, body=route_data)

    test_data_json = load_test_data()
    response = post_calculate_route(test_data_json)

    assert response.status_code == 200

    response_json = response.json()

    requirements = test_data_json['requirement']

    requirement_ids = []
    for requirement in requirements:
        requirement_ids.append(requirement['id'])

    routepoints = response_json['routepoint']
    assert len(routepoints) == 0

    achievabilities = response_json['achievability'].values()

    assert len(achievabilities) == len(requirements)

    achievability_requirement_ids = []

    for achievability in achievabilities:
        achievability_requirement_ids.append(achievability['requirement_id'])
        if achievability['requirement_id'] == requirements[0]['id']:
            assert achievability['achievable'] == True
            assert len(achievability['problems']) == 0
        else:
            assert achievability['achievable'] == False
            assert len(achievability['problems']) == 1
            assert achievability['problems'][0]['description'] == 'No route to requirement'

    assert requirement_ids == achievability_requirement_ids

@responses.activate
def test_calculate_route_spatial_validation_failed():
    conflicting_spatial_constraints_data = '{"type":"FeatureCollection","features":[{"type":"Feature", "properties": {}, "geometry":{"coordinates":[],"type":"Polygon"}}]}'

    responses.reset
    responses.add(responses.GET, calculate_leg_url, status=200, body=calculate_leg_data)
    responses.add(responses.GET, spatial_constraints_url, status=200, body=conflicting_spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=vehicle_performance_data)
    responses.add(responses.POST, route_url, status=200, body=route_data)

    test_data_json = load_test_data()
    response = post_calculate_route(test_data_json)

    assert response.status_code == 200

    response_json = response.json()

    requirements = test_data_json['requirement']

    requirement_ids = []
    for requirement in requirements:
        requirement_ids.append(requirement['id'])

    routepoints = response_json['routepoint']
    assert len(routepoints) == 0

    achievabilities = response_json['achievability'].values()

    assert len(achievabilities) == len(requirements)

    achievability_requirement_ids = []

    for achievability in achievabilities:
        achievability_requirement_ids.append(achievability['requirement_id'])
        assert achievability['achievable'] == False
        assert len(achievability['problems']) == 1
        assert achievability['problems'][0]['description'].startswith('Requirement conflicts with spatial constraint:')

    assert requirement_ids == achievability_requirement_ids

@responses.activate
def test_calculate_route_performance_validation_failed():
    test_data_json = load_test_data()
    requirements = test_data_json['requirement']
    last_requirement = requirements[len(requirements)-1]
    conflicting_altitude = last_requirement['altitude']-10
    conflicting_vehicle_performance_data = '{"maximum_altitude":' + str(conflicting_altitude) + '}'

    responses.reset
    responses.add(responses.GET, calculate_leg_url, status=200, body=calculate_leg_data)
    responses.add(responses.GET, spatial_constraints_url, status=200, body=spatial_constraints_data)
    responses.add(responses.GET, vehicle_performance_url, status=200, body=conflicting_vehicle_performance_data)
    responses.add(responses.POST, route_url, status=200, body=route_data)

    response = post_calculate_route(test_data_json)

    assert response.status_code == 200

    response_json = response.json()

    requirement_ids = []
    for requirement in requirements:
        requirement_ids.append(requirement['id'])

    routepoints = response_json['routepoint']
    assert len(routepoints) == 0

    achievabilities = response_json['achievability'].values()

    assert len(achievabilities) == len(requirements)

    achievability_requirement_ids = []

    for achievability in achievabilities:
        achievability_requirement_ids.append(achievability['requirement_id'])
        for requirement in requirements:
            if requirement['id'] == achievability['requirement_id']:
                if requirement['altitude'] > conflicting_altitude:
                    assert achievability['achievable'] == False
                    assert len(achievability['problems']) == 1
                    assert achievability['problems'][0]['description'].startswith('Requirement altitude')
                else:
                    assert achievability['achievable'] == True
                    assert len(achievability['problems']) == 0
    assert requirement_ids == achievability_requirement_ids