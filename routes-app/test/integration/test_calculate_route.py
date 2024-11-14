import requests
import json

def test_calculate_route():
    url = 'http://localhost:8080/routes/calculate-route'
    headers = {'Content-Type': 'application/json' } 
    test_data_file = open('test/test.json')
    test_data_json = json.load(test_data_file)
     
    response = requests.post(url, headers=headers, data=json.dumps(test_data_json, indent=4))       
    
    assert response.status_code == 200
   
    response_json = response.json()

    requirements = test_data_json['requirement']    
    
    requirement_ids = []    
    for requirement in requirements:
        requirement_ids.append(requirement['id'])

    routepoints = response_json['routepoint']
    
    assert len(routepoints) > 0

    last_routepoint = routepoints[len(routepoints) - 1]
    end = requirements[len(requirements) - 1]    
    assert last_routepoint['latitude'] == end['latitude']
    assert last_routepoint['longitude'] == end['longitude']
    assert last_routepoint['altitude'] == end['altitude']
    
    satisfied_requirement_ids = []
    for routepoint in routepoints:
    	if routepoint['satisfies_requirement_id']:
            satisfied_requirement_ids.append(routepoint['satisfies_requirement_id'])
    
    assert requirement_ids == satisfied_requirement_ids
    
    achievabilities = response_json['achievability'].values()
    
    assert len(achievabilities) == len(requirements)    
    	
    achievability_requirement_ids = []
    
    for achievability in achievabilities:
        achievability_requirement_ids.append(achievability['requirement_id'])
        assert achievability['achievable'] == True    
        assert len(achievability['problems']) == 0

    assert requirement_ids == achievability_requirement_ids
