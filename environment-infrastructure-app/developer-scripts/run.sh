cd ..
sudo docker run --name environment-infrastructure-app --rm -it -p 8083:8080 --network app-network environment-infrastructure-app
cd developer-scripts
