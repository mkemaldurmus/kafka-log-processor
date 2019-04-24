#!/usr/bin/env bash
mvn clean  package -DskipTests
mv ./target/ProducerLog.jar ProducerLog.jar
mv ./target/ConsumerLog.jar ConsumerLog.jar

docker build -t kafka-stream:lastest .


docker run --name kafka-stream -d kafka-stream:lastest