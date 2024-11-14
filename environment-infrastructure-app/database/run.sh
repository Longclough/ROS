sudo docker run --name environment-infrastructure-db --rm -it -e MYSQL_ROOT_PASSWORD=change-me -v mysql:/var/lib/mysql --network app-network environment-infrastructure-db
