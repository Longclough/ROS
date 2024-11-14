"""
This script performs unit tests for the vehicle_type service
"""

import app.main
import pytest
import json

vehicle_types = ['Spitfire', 'Vulcan']

"""
Check results are returned and contain correct data.
"""
@pytest.mark.asyncio
async def test_vehicle_type_results():
   
    for vt in vehicle_types:
        response = await app.main.get_vehicle_type_data(vt)
       
        response_json = json.load(open(response))
           
        datatype = response_json['type']
        assert datatype == "VehicleTypeData"

        id = response_json['id']
        assert id == vt

        params = response_json['params']
        assert len(params) > 0