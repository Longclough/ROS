from pydantic import BaseModel
from typing import Optional, Dict

class Routepoint(BaseModel):
    latitude: float
    longitude: float
    altitude: float
    satisfies_requirement_id: Optional[str]

class Requirement(BaseModel):
    id: str
    latitude: float
    longitude: float
    altitude: float

class Requirements(BaseModel):
    requirement: list[Requirement]

class LegRequirement(BaseModel):
    start: Requirement
    end: Requirement

class ValidationProblem(BaseModel):
    description : str

class Achievability(BaseModel):
    requirement_id: str
    achievable: bool
    problems: list[ValidationProblem]    

class Route(BaseModel):
    routepoint: list[Routepoint] = []
    achievability: Dict[str, Achievability] = {}

class VehiclePerformance(BaseModel):
    maximum_altitude: float