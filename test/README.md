# Introduction 
This project is the interface to a simple routing algorithm; it allows users to plot waypoints on a map and calculate a route between them, starting from the vehicle's current position.

# Design Decisions 
This project is going to make calls to the Routes App, which is a RESTful API, using HTTP Requests. Responses will be returned to the UI as JSON to be displayed.

# Getting Started
Initial Setup: 
1.	Clone the worldwind repository in a folder adjacent to this repo, the folder name must be "worldwind" all lower case - https://github.com/NASAWorldWind/WorldWindJava/releases/download/v2.2.1/worldwind-v2.2.1.zip
2.	Clone the Pyramid Routing Solution repository and run the pull_repos.py script to clone all other required projects - https://airlabs-poe@dev.azure.com/airlabs-poe/Dionysus/_git/PYRAMIDRoutingApplication
3.	Change the host names in urls in Application.java and RestCommsHandler.java to localhost to run the application locally. 
4.	Build and Run in IDE of choice.
User Guide: 
TODO: Once application is finished 