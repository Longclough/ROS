from fastapi import APIRouter
import requests
import os
import json
from app.routes_data_model import Requirement, ValidationProblem, Achievability
from shapely import Point, to_wkt

router = APIRouter()

def validate_spatial_constraints(requirement : Requirement):
    result = []
    point = Point(requirement.longitude, requirement.latitude)    
    bounds = to_wkt(point)
    url = os.getenv('SPATIAL_CONSTRAINTS_SERVICE', default="http://routes-required-services-app:8080/routes-required-services/spatial-constraints") + "?bounds=" + bounds + "&height=" + str(requirement.altitude)
    response = requests.get(url)
    for feature in response.json().get("features"):
        problem = ValidationProblem(description="Requirement conflicts with spatial constraint: " + json.dumps(feature))
        result.append(problem)
    return result
        
def validate_performance_constraints(requirement : Requirement):
    result = []
    url = os.getenv('VEHICLE_PERFORMANCE_SERVICE', default="http://routes-required-services-app:8080/routes-required-services/vehicle-performance")
    response = requests.get(url)
    max_altitude = response.json()['maximum_altitude']
    if requirement.altitude > max_altitude:
        problem = ValidationProblem(description="Requirement altitude " + str(requirement.altitude) + " is above max altitude: " + str(max_altitude))
        result.append(problem)    
    return result 

@router.get('')
async def validate_requirement(requirement : Requirement):
    problems = []
    problems.extend(validate_spatial_constraints(requirement))
    problems.extend(validate_performance_constraints(requirement))    
    result = Achievability(requirement_id=requirement.id, problems=problems, achievable=not problems)
    return result
