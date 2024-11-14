import requests
import json

def test_validator():
    url = 'http://localhost:8080/routes/validator'
    headers = {'Content-Type': 'application/json' } 
    test_data_file = open('test/test.json')
    test_data_json = json.load(test_data_file)
    requirement = test_data_json['requirement'][0]
     
    response = requests.get(url, headers=headers, data=json.dumps(requirement, indent=4))       
    
    assert response.status_code == 200
   
    response_json = response.json()

    assert response_json['requirement_id'] == requirement['id']
    assert response_json['achievable'] == True    
    assert len(response_json['problems']) == 0
