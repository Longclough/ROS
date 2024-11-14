cd ..
docker run --name routes-calculation-extension-app --rm -it -p 8081:8080 -e SPATIAL_CONSTRAINTS_SERVICE=http://routes-required-services-app:8080/routes-required-services/spatial-constraints --network app-network routes-calculation-extension-ros-app
cd developer-scripts
