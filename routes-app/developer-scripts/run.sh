cd ..
sudo docker run --name routes-app --rm -it -p 8081:8080 -e POST_ROUTE_SERVICE=http://routes-required-services-app:8080/routes-required-services/route -e CALCULATE_LEG_SERVICE=http://routes-calculation-extension-app:8080/routes-calculation-extension/calculate-leg --network app-network routes-app
cd developer-scripts
