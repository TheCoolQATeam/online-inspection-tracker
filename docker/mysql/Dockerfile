
FROM mysql:5.7

MAINTAINER inspection
EXPOSE 3306
LABEL version="1.0.1" description="mysql镜像, 初始化库表" by="inspection"

ENV MYSQL_DATABASE=online_inspection_tracker
ENV MYSQL_ROOT_PASSWORD=123456

COPY ./my.cnf /etc/mysql/
COPY ./init.sql /docker-entrypoint-initdb.d
