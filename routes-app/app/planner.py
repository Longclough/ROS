from fastapi import APIRouter
import requests
import os
import asyncio
import app.validator
from app.routes_data_model import LegRequirement, Requirements, Requirement, Route, Routepoint, Achievability, ValidationProblem

router = APIRouter()

@router.post("/routes/calculate-route")
async def calculate_route(requirements : Requirements):
    route = Route()
    all_achievable = True
    

    validations = []
    for requirement in requirements.requirement:
        validations.append(app.validator.validate_requirement(requirement))

    achievabilities = await asyncio.gather(*validations)

    for achievability in achievabilities:
        route.achievability[achievability.requirement_id] = achievability
        if not achievability.achievable:
            all_achievable = False

    if not all_achievable:
        return route
  
    if(len(requirements.requirement) > 0):
        start = requirements.requirement[0]
        route.routepoint.append(Routepoint(latitude=start.latitude, longitude=start.longitude, altitude=start.altitude, satisfies_requirement_id=start.id))

        legs = await calc_legs(requirements.requirement)
        
        for i in range(0, len(legs)):
            leg = legs[i]
            if leg:
                route.routepoint.extend(leg)
            else:
                problems = []
                problems.append(ValidationProblem(description="No route to requirement"))                
                achievability = Achievability(requirement_id=requirements.requirement[i + 1].id, achievable=not problems, problems=problems)
                route.achievability[achievability.requirement_id] = achievability
                all_achievable = False
    

        if all_achievable:
            print("Trying to print")
            url = os.getenv('POST_ROUTE_SERVICE', default="http://routes-required-services-app:8080/routes-required-services/route")
            requests.post(url, data=route.json())   
        else:
            route.routepoint = []
    return route

async def calculate_leg(start : Requirement, end : Requirement):
    data = LegRequirement(start=start, end=end)
    url = os.getenv('CALCULATE_LEG_SERVICE', default="http://routes-calculation-extension-app:8080/routes-calculation-extension/calculate-leg")
    response = requests.get(url, data=data.json())
    routepoints = response.json()
    if routepoints:
        last_routepoint = routepoints[len(routepoints)-1]
        last_routepoint['satisfies_requirement_id'] = end.id
    return routepoints

async def calc_legs(requirements):
    leg_calculations = []        
    for i in range(len(requirements)-1):
        leg_calculations.append(calculate_leg(requirements[i], requirements[i+1]))
    return await asyncio.gather(*leg_calculations)