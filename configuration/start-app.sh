#!/bin/bash

docker rmi -f ericdallo/btgclicksign
docker pull ericdallo/btgclicksign
docker rm -f btgclicksign
docker run -d --name btgclicksign -p 80:7000  ericdallo/btgclicksign
