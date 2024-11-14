# Provides weather app services

from http import HTTPStatus
from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from shapely import from_wkt, Polygon
from shapely.geometry import shape
import geojson
import fiona

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,
    allow_methods=["*"],
    allow_headers=["*"],
)

# returns geojson features of bad weather polygons from shp_file that intersect with bounds provided
def get_features(bounds, shp_file): 
    features = []
    records = fiona.open(shp_file)
    for record in records:                    
        polygon = shape(record['geometry'])
        if polygon.intersects(bounds):
            feature = geojson.Feature(geometry=polygon, properties={})
            features.append(feature)
    return features

# returns polygons of bad weather within bounds provided
@app.get("/weather/get-bad-weather", status_code=HTTPStatus.OK) 
async def main(bounds: str):

    shp_file = "./app/shapefiles/wx.shp"

    features = []

    bounds_geom = from_wkt(bounds, on_invalid='ignore')
    if bounds_geom == None:
        raise HTTPException(status_code=HTTPStatus.UNPROCESSABLE_ENTITY, detail= f'Bounds {bounds} are invalid wkt')

    features.extend(get_features(bounds_geom, shp_file))
    result = geojson.FeatureCollection(features)

    return result