#!/bin/bash

APP=btgclicksign

docker rmi -f ericdallo/$APP
docker pull ericdallo/$APP
docker rm -f $APP
docker run -d --name $APP \
        -v /opt/application.properties:/app/src/main/resources/application.properties
        --link mysql:mysql
        -p 80:7000  ericdallo/$APP
