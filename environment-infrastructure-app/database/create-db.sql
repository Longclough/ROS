CREATE USER 'ei'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'ei'@'%' WITH GRANT OPTION;

DROP DATABASE IF EXISTS environment_infrastructure;

CREATE DATABASE environment_infrastructure;

USE environment_infrastructure;
