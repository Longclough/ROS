"""
This module provides the routes-required-services services
"""

from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from http import HTTPStatus
import paho.mqtt.client as mqtt
import requests
import geojson
import os
from shapely import from_wkt
from app.routes_data_model import Route, VehiclePerformance

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,
    allow_methods=["*"],
    allow_headers=["*"],
)

client = mqtt.Client("routes")
client.connect(os.getenv('MQTT_BROKER', "mqtt"), port=int(os.getenv('MQTT_PORT', "1883")), keepalive=600)
#client.connect("172.26.0.39", 1883, 600)
#client.connect("localhost", 1883, 600)


""" 
Returns spatial constraints above height within bounds
"""
@app.get("/routes-required-services/spatial-constraints")
async def get_spatial_constraints(bounds: str, height: float):

    bounds_geom = from_wkt(bounds, on_invalid='ignore')
    if bounds_geom == None:
        raise HTTPException(status_code=HTTPStatus.UNPROCESSABLE_ENTITY, detail= f'Bounds {bounds} are invalid wkt')    

    #Feature storage
    all_features = []

#    #Rest API for air space
#    url = os.getenv('AIRSPACE_SERVICE', default="http://environment-infrastructure-app:8080/environment-infrastructure/airspace") + "?bounds=" + bounds
#    #Get Json data
#    response = requests.get(url)
#    #Interpret data
#    environment_infrastructure_features = geojson.loads(response.text)
#    #List of features
#    print("Got " + str(len(environment_infrastructure_features["features"])) + " features from environment infrastructure")
#    #Adds feature to all_features array
#    all_features.extend(environment_infrastructure_features["features"])

    url = os.getenv('GEOGRAPHY_SERVICE', default="http://geography-app:8080/geography/terrain") + "?bounds=" + bounds + "&aboveHeight=" + str(250)
    response = requests.get(url)
    geography_features = geojson.loads(response.text)
    print("Got " + str(len(geography_features["features"])) + " features from geography")
    all_features.extend(geography_features["features"])
    
    url = os.getenv('WEATHER_SERVICE', default="http://weather-app:8080/weather/get-bad-weather") + "?bounds=" + bounds
    response = requests.get(url)
    weather_features = geojson.loads(response.text)
    print("Got " + str(len(weather_features["features"])) + " features from weather")
    all_features.extend(weather_features["features"])

    print("Got " + str(len(all_features)) + " features in total")

    #Assigns Json data to objects; describes the objects type, geometry and properties
    result = geojson.FeatureCollection(all_features)

    return result

""" 
Returns vehicle performance data
"""
@app.get("/routes-required-services/vehicle-performance")
async def get_vehicle_performance():    
    url = os.getenv('VEHICLE_PERFORMANCE_SERVICE', default="http://vehicle-performance-app:8080/vehicle_performance/get-params")
    response = requests.get(url)
    response_json = response.json()
    print(response_json)
    maximum_altitude = 0
    
    for param in response_json['params']:
        if param['type'] == 'max_altitude':
            maximum_altitude = param['value']
    
    result = VehiclePerformance(maximum_altitude = maximum_altitude)
    return result

""" 
Posts the route to mqtt
"""

@app.post("/routes-required-services/route")
async def post_route(route: Route):
    client.publish("route", route.json())

