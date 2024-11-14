# Introduction 
This is a simple implementation of the PRA Environment Infrastructure component that only supports the retrieval of airspace in a bounding box. Airspace is loaded from a AIXM 5 XML file into a mysql database.

# Getting Started
The component provides a RESTful API that is run within a Tomcat web server. The component should be run within a Docker container.
##Installation process
- Clone this repository.
- Airspace data is currently loaded from a hardcoded file (2023_XML_WEF2023-05-18_EXP2023-04-14_CRC_1D03AC5C.xml).
##Software dependencies
Run in Docker:
- The Docker engine is required to run as a Docker container.
##API references
TBD

# Build and Test
Run in Docker:
- Run the build.sh script to build the Docker container.
- Run the database/run.sh script to run the database Docker container.
- Run the run.sh script to run the Docker container.
- Run the test.sh script to test the API.

Load additional data:
- Additional data can be loaded by changing the file referenced by load.sh.

# Future Enhancements
- Remove hardcoded data file
- Implement more Environment Infrastructure services