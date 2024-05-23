FROM nginx

MAINTAINER inspection
EXPOSE 5173
LABEL version="1.0.1" description="nginx镜像, " by="inspection"

COPY dist /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/
