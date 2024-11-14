FROM mysql:8.0.33-debian

COPY create-db.sql /scripts/create-db.sql

CMD ["mysqld", "--init-file=/scripts/create-db.sql"]
