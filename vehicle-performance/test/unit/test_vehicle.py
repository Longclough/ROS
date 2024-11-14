"""
This script performs unit tests for the vehicle_type service
"""
import app.main
import pytest
import json

vehicles = ['XH558', 'PM631']

"""
Check results are returned and contain correct data.
"""
@pytest.mark.asyncio
async def test_vehicle_results():
    
    for v in vehicles:
        response = await app.main.get_vehicle_data(v)
       
        response_json = json.load(open(response))
                   
        datatype = response_json['type']
        assert datatype == "VehicleData"

        id = response_json['id']
        assert id == v

        params = response_json['params']
        assert len(params) > 0