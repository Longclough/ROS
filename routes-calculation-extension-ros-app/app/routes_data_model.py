"""
This module provides a shared data model for the Routes component
"""

from pydantic import BaseModel
from typing import Optional

#Data structure for parent route API, tells the API how to interpret the data
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