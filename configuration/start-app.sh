#!/bin/bash

docker rmi -f ericdallo/btg-clicksign
docker pull ericdallo/btg-clicksign
docker rm -f btg-clicksign
docker run -d --name btg-clicksign -p 80:7000  ericdallo/btg-clicksign
