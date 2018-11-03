#!/bin/bash
set -ve

./gradlew build

exec java -jar build/libs/btgclicksign-*.jar
