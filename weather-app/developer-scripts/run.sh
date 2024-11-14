# runs and hosts containerised weather app on localhost

cd ../

sudo docker run --name weather-app --rm -it -p 8085:8080 weather-app

cd developer-scripts