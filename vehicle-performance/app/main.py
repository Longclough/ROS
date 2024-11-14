"""
This module provides the vehicle performance services
"""

from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import FileResponse
from pathlib import Path
from http import HTTPStatus
import os

main_app_path = os.path.dirname(__file__)
relative_path_to_data_root = "../data"
data_root_path = Path(os.path.join(main_app_path, relative_path_to_data_root))

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,
    allow_methods=["*"],
    allow_headers=["*"],
)

def get_datafile(path: Path, filename: str):
    datafile = data_root_path / path / (filename + ".json")
    if not datafile.is_file():                    
        raise HTTPException(status_code=HTTPStatus.NO_CONTENT, detail= f'No performance data available for {filename}.')
    return datafile

# Backwards compatability with V1 API for Spitfire type data.
@app.get("/vehicle_performance/get-params", response_class=FileResponse)
async def get_vehicle_type_data():
    vehicle_type_data = get_datafile("vehicle_types", "Spitfire")
    return vehicle_type_data


# V2 API for vehicle type data.
@app.get("/vehicle_performance/v2/vehicle_type/get-params", response_class=FileResponse)
async def get_vehicle_type_data(vehicle_type: str):
    vehicle_type_data = get_datafile("vehicle_types", vehicle_type)
    return vehicle_type_data

# V2 API for specific vehicle data.
@app.get("/vehicle_performance/v2/vehicle/get-params", response_class=FileResponse)
async def get_vehicle_data(id: str):
    vehicle_data = get_datafile (data_root_path / "vehicles", id)
    return vehicle_data