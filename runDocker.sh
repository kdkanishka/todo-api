#!/bin/bash

docker stop todoapi1
docker rm todoapi1
docker run --name todoapi1 \
    -e ENV=PROD \
    -e QUARKUS_PROFILE=prod \
    -e BACKEND_SERVICE=http://192.168.8.103:18080 \
    -itd -p 19090:9090 kdkanishka/todo-api:1.0


