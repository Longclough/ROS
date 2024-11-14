import requests
import json

def test_requirements():
    url = 'http://localhost:8080/routes/requirements'
    headers = {'Content-Type': 'application/json' } 
    test_data_file = open('test/test.json')
    test_data_json = json.load(test_data_file)
     
    response = requests.post(url, headers=headers, data=json.dumps(test_data_json, indent=4))       
    
    assert response.status_code == 200
   
    achievabilities = response.json()    
    requirements = test_data_json['requirement']
    
    requirement_ids = []    
    for requirement in requirements:
        requirement_ids.append(requirement['id'])
    
    assert len(achievabilities) == len(requirements)    
    	
    achievability_requirement_ids = []
    
    for achievability in achievabilities:
        achievability_requirement_ids.append(achievability['requirement_id'])
        assert achievability['achievable'] == True    
        assert len(achievability['problems']) == 0

    assert requirement_ids == achievability_requirement_ids
