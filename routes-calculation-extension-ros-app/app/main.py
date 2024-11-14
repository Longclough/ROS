"""
This module provides the calculation extension services
"""

from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from shapely import LineString
import routescalculationextensionros
import geojson
import json
import requests
import os
from app.routes_data_model import Requirement, Routepoint

#Created API framework
app = FastAPI()

#configure API
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,
    allow_methods=["*"],
    allow_headers=["*"],
)

"""
Returns routepoints that avoid spatial constraints.
Uses C++ library via pybind.
"""
#Contents of the API
@app.get("/routes-calculation-extension/calculate-leg")
async def calculate_leg(start : Requirement, end : Requirement):

    start_point = routescalculationextensionros.Point(start.latitude, start.longitude, start.altitude)
    end_point = routescalculationextensionros.Point(end.latitude, end.longitude, end.altitude)
    points = routescalculationextensionros.calculateLeg(start_point, end_point, constraints_callback)
    p = []
    p.append((start_point.lon, start_point.lat))
    p.append((end_point.lon, end_point.lat))

    line_string2 = LineString(p)
    ls2 = geojson.Feature(geometry=line_string2, properties={})
    print(f"\n\n\nls2: {ls2}\n\n\n")
    
    routepoints = []
    coords = []   

    for point in points:
        routepoint = Routepoint(latitude=point.lat, longitude=point.lon, altitude=point.alt, satisfies_requirement_id=None)
        routepoints.append(routepoint)
        coords.append((point.lon, point.lat))         

    line_string = LineString(coords)
    ls = geojson.Feature(geometry=line_string, properties={})
    print(f"Coordinate list in the line string is {ls}")

    #line_string = LineString(routepoints)
    #ls = geojson.Feature(geometry=line_string, properties={})
    print(f"\n\n\n\nRoutepoints are: {routepoints}\n\n\n")


    return routepoints

"""
Returns json for spatial constraints within wkt bounds above height
"""
def constraints_callback(wkt, height):

    url = os.getenv('SPATIAL_CONSTRAINTS_SERVICE', default="http://routes-required-services-app:8080/routes-required-services/spatial-constraints") + "?bounds=" + wkt + "&height=" + str(250)
    response = requests.get(url)
    json_data = response.json()
    #print(json_data)

    return geojson.dumps(json_data)
