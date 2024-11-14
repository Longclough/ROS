# Introduction 
This is a simple implementation of the PRA Routes component that only supports planning a route from a single requirements source. Planned routes are not stored or monitored.

# Getting Started
The component provides a RESTful API that is run within the Uvicorn ASGI web server. The component can be run locally or within a Docker container.

## Installation process
- Clone this repository.

## Software dependencies
Run locally:
- Python 3
- pip
- Python modules captured in requirements.txt; to install execute: pip install -r requirements.txt.

Run in Docker:
- The Docker engine is required to run as a Docker container.

Other components:
- A required services adaptor must be run to connect to other services, this must be at routes-required-services-app:8080
- A calculation extension must be run to calculate each leg, this must be at routes-calculation-extension-app:8080

## API references
The API is automatically documented by FastAPI, an OpenAPI definition can be accessed through the localhost:8080/docs URL.

# Build and Test
Run in Docker:
- Run the build.sh script to build the Docker container.
- Run the run.sh script to run the Docker container.
- Run the test.sh script to test the API.

Run locally:
- Run: uvicorn main:app --reload --port 8080 --host 0.0.0.0
- Run the test.sh script to test the API, this uses test.json to define the routing requirements.

# Future Enhancements
- Implement more Routes services e.g. monitoring.