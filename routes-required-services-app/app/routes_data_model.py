"""
This module provides a shared data model for the Routes component
"""

from pydantic import BaseModel
from typing import Optional

class Routepoint(BaseModel):
    latitude: float
    longitude: float
    altitude: float
    satisfies_requirement_id: Optional[str]

class Route(BaseModel):
    routepoint: list[Routepoint] = []

class Requirement(BaseModel):
    latitude: float
    longitude: float
    altitude: float

class Requirements(BaseModel):
    requirement: list[Requirement]

class LegRequirement(BaseModel):
    start: Requirement
    end: Requirement

class VehiclePerformance(BaseModel):
    maximum_altitude: float