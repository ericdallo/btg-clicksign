FROM openjdk:8 

COPY . /app

RUN mkdir -p /app && \
    cd /app && \
    ./gradlew build

WORKDIR /app

ENTRYPOINT /app/docker/startup.sh

EXPOSE 7000
