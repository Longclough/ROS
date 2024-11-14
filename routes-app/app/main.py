from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
import app.planner
import app.validator
from app.routes_data_model import Requirements

fast_api = FastAPI()

fast_api.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=False,
    allow_methods=["*"],
    allow_headers=["*"],
)

fast_api.include_router(app.planner.router)
fast_api.include_router(app.validator.router, prefix="/routes/validator")

@fast_api.post("/routes/requirements")
async def post_requirements(requirements : Requirements):
    # in the future this will pass in all unsatisfied requirements
    route = await app.planner.calculate_route(requirements)

    achievabilities = []
    for requirement in requirements.requirement:
        achievabilities.append(route.achievability[requirement.id])

    return achievabilities