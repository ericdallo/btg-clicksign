FROM openjdk:8 

COPY . /app

RUN mkdir -p /app

WORKDIR /app

ENTRYPOINT /app/docker/startup.sh

EXPOSE 7000
