"""
This module provides the geography services
"""

from http import HTTPStatus
from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from shapely import from_wkt
from shapely.geometry import shape
import math
from pathlib import Path
import subprocess
from subprocess import call
import sys
import fiona
import glob
import os
import geojson


absolute_path = os.path.dirname(__file__)
relative_path = "../data"
data_path = Path(os.path.join(absolute_path, relative_path))

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,
    allow_methods=["*"],
    allow_headers=["*"],
)

""" 
Returns geojson features within the bounds from a shapefile at shp_file_path
"""
def get_features(bounds, shp_file_path):
    features = []
    if shp_file_path.is_file():
        records = fiona.open(shp_file_path)
        for record in records:                    
            polygon = shape(record['geometry'])
            if polygon.intersects(bounds):
                feature = geojson.Feature(geometry=polygon, properties={})
                features.append(feature)
    return features

""" 
Converts a geotiff file of terrain elevation data (SRTM) to a shapefile containing polygons for areas of terrain above above_height.
- gdal_calc creates a temporary tif file with all areas below above_height set to 0
- gdal_polygonize extracts polygons from the temporary tif file to a temporary shapefile
- ogr2ogr filters polygons from the temporary shapefile to the output shapefile
"""
def convert_tif_to_shp(tif_file_path, shp_file_path, tmp_path, above_height):
    for f in glob.glob("../data/tmp/temp*"):
        os.remove(f)
    temp_tif = str(tmp_path / 'temp.tif')
    temp_shp = str(tmp_path / 'temp.shp')
    print("Running gdal_calc")
    subprocess.call([sys.executable, r"/usr/bin/gdal_calc.py", '-A', tif_file_path, '--outfile=' + temp_tif,'--calc=\"A>=' + str(250) +'\"', '--NoDataValue=0', '--quiet'])
    print("Running gdal_polygonize")
    subprocess.call([sys.executable, r"/usr/bin/gdal_polygonize.py", temp_tif, temp_shp, '-q'])
    print("Running ogr2ogr")
    subprocess.call(["ogr2ogr", shp_file_path, temp_shp, '-where', 'DN=1'])

""" 
Returns the file name of a SRTM tile from its corner x and y
"""
#def get_file_name(x, y):
#    lat = ("n" if y >= 0 else "s") + str(abs(y)).zfill(2)
#    lon = ("e" if x >= 0 else "w") + str(abs(x)).zfill(3)
#    return lat + "_" + lon + "_1arc_v3"
#    #return "n54_w004_1arc_v3"

""" 
Returns polygons of terrain above aboveHeight within bounds
"""
@app.get("/geography/terrain", status_code=HTTPStatus.OK)
async def get_terrain(bounds: str, aboveHeight: float):
    processed_path = data_path / 'processed'
    processed_path.mkdir(parents=False, exist_ok=True)
    tmp_path = data_path / 'tmp'
    tmp_path.mkdir(parents=False, exist_ok=True)

    features = []
    #area = ("-2.7562833",  "54.1964690", "-1.7645164",  "53.2074957")
    #area = [("-2.7562833  54.1964690"), ("-2.7562833  53.2074957"), ("-1.7645164  54.1964690"), ("-1.7645164  53.2074957"), ("-2.2603998  53.7019824")]
    bounds_geom = from_wkt(bounds, on_invalid='ignore')
    if bounds_geom == None:
        raise HTTPException(status_code=HTTPStatus.UNPROCESSABLE_ENTITY, detail= f'Bounds {bounds} are invalid wkt')
    
    print(f"Bounds are {bounds}")
    print("Requesting terrain above " + str(250) + " for bounds " + str(bounds_geom.bounds))

    #for x in range(math.floor(bounds_geom.bounds[0]), math.ceil(bounds_geom.bounds[2])):
    #    for y in range(math.floor(bounds_geom.bounds[1]), math.ceil(bounds_geom.bounds[3])):
    #        print("Loading tile " + str(x) + ", " + str(y))
    file_name = "n53_w003_1arc_v3"
    print(file_name)
    print(aboveHeight)
    tif_file_path = data_path / (file_name + ".tif")
    shp_file_path = processed_path / (file_name + "_contour_" + str(2500) + ".shp")
    
    if not shp_file_path.is_file():                    
        if tif_file_path.is_file():    
            convert_tif_to_shp(tif_file_path, shp_file_path, tmp_path, 250)
        else:
            raise HTTPException(status_code=HTTPStatus.INTERNAL_SERVER_ERROR, detail= f'Required file {file_name} does not exist')
    
    features.extend(get_features(bounds_geom, shp_file_path))
    print(f"These are the boundaries {bounds_geom}")
    result = geojson.FeatureCollection(features)
    return result