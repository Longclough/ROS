# Introduction 
This is a simple implementation of the PRA Geography component that only supports the retrieval of terrain above a specified height.

# Getting Started
The component provides a RESTful API that is run within the Uvicorn ASGI web server. The component can be run locally or within a Docker container.
##Installation process
- Clone this repository.
- Terrain elevation data is loaded from geotiff files in the data subdirectory. Additional data can be downloaded from https://earthexplorer.usgs.gov/.
##Software dependencies
Run locally:
- Python 3
- pip
- Python modules captured in requirements.txt; to install execute: pip install -r requirements.txt.

Run in Docker:
- The Docker engine is required to run as a Docker container.
##API references
The API is automatically documented by FastAPI, an OpenAPI definition can be accessed through the localhost:8084/docs URL.

# Build and Test
Run in Docker:
- Run the build.sh script to build the Docker container.
- Run the run.sh script to run the Docker container.
- Run the test.sh script to test the API.

Run locally:
- Run: uvicorn main:app --reload --port 8084 --host 0.0.0.0
- Run the test.sh script to test the API.

# Future Enhancements
- Use USGS M2M API to downloaded required data
- Implement more Geography services