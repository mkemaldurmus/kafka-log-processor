import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerLog {
    public static void main(String[] args) {
        String topicName = "topic-test";
        Properties configProperties = new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "bigdat");
        configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "örne");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(configProperties);
        kafkaConsumer.subscribe(Collections.singletonList(topicName));

        MysqlConnector connector = MysqlConnector.getConnector();
        //connector.createTable();

        try {


            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
                records.iterator().forEachRemaining(record -> {
                    if (!record.value().isEmpty()) {
                        String value= record.value();
                        System.out.println(value);
                        String[] array = value.split(" ");

                        ServerLog log = new ServerLog(array[0], array[1], array[2], array[3]);
                        connector.insertLog(log);
                    }

                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}