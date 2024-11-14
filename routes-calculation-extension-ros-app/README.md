# Introduction 
This is an implementation of the routes calculation extension that uses a costmap and A* router derived from the Robot Operating System 2 navigation stack (https://navigation.ros.org/).

# Getting Started
The component provides a RESTful API that is run within the Uvicorn ASGI web server. The component can be run locally or within a Docker container.
The python API encapsulates a C++ shared library (via pybind)
##Installation process
- Clone this repository.
- Run install.sh
##Software dependencies
CPP library (install.sh installs these via apt):
- geos
- jsoncpp
- CMake

Run locally:
- Python 3
- pip
- Python modules captured in requirements.txt; to install execute: pip install -r requirements.txt.

Run in Docker:
- The Docker engine is required to run as a Docker container.

Other components:
- A required services adaptor must be run to connect to other services, this must be at routes-required-services-app:8080
- This component is called by the routes-app component
##API references
The API is automatically documented by FastAPI, an OpenAPI definition can be accessed through the localhost:8081/docs URL.

# Build and Test
Run in Docker:
- Run the build.sh script to build the Docker container and cpp libraries

Run locally:
- Run the build_cpp.sh script to build the cpp libraries 
- Run: uvicorn main:app --reload --port 8081 --host 0.0.0.0
- Run the test.sh script to test the API, this uses test.json to define the leg start and end.