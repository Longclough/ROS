# Introduction 
This is a simple implementation of the routes required services adaptor that:
- requests spatial constraints from weather, geography and environment infrastructure components and returns a consolidated GeoJSON feature collection. 
- publishes routes to MQTT.

# Getting Started
The component provides a RESTful API that is run within the Uvicorn ASGI web server. The component can be run locally or within a Docker container.
##Installation process
- Clone this repository.
##Software dependencies
Run locally:
- Python 3
- pip
- Python modules captured in requirements.txt; to install execute: `pip install -r requirements.txt`.

Run in Docker:
- The Docker engine is required to run as a Docker container.

Other components:
- A geography component must be running, this must be at `geography-app:8080`
- A weather component must be running, this must be at weather-app:8080
- A environment-infrastructure component must be running, this must be at environment-infrastructure-app:8080
- A MQTT broker must be running, this must be at mqtt:1883
- This component is called by a routes calculation extension component
##API references
The API is automatically documented by FastAPI, an OpenAPI definition can be accessed through the localhost:8082/docs URL.

# Build and Test
Run in Docker:
- Run the build.sh script to build the Docker container.
- Run the run.sh script to run the Docker container.
- Run the test.sh script to test the API.

Run locally:
- Run: uvicorn main:app --reload --port 8082 --host 0.0.0.0
- Run the test.sh script to test the API, this uses test.json to define the leg start and end.