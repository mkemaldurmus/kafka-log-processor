FROM ubuntu:latest

ENV KAFKA_HOME /usr/local/kafka
ADD ./start-kafka.sh /scripts/
ADD ./log.csv /scripts/
ADD ./ProducerLog.jar /scripts/
ADD ./ConsumerLog.jar /scripts/

# install java + others
RUN apt-get update && apt-get install -y \
  wget \
  vim \
  openjdk-8-jdk

# install kafka
RUN wget https://archive.apache.org/dist/kafka/0.10.2.0/kafka_2.11-0.10.2.0.tgz && \
  tar -xzf kafka_2.11-0.10.2.0.tgz && \
  mv kafka_2.11-0.10.2.0 $KAFKA_HOME

CMD ["/scripts/start-kafka.sh"]
