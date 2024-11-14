cd ..
sudo docker build -t environment-infrastructure-app .
cd database
./build.sh
cd ..
cd developer-scripts
