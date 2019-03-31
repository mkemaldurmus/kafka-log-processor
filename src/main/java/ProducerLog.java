import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Scanner;

public class ProducerLog {
    private static Scanner in;

    public static void main(String[] args) throws Exception {

        String topicName = "topic-test";
        in = new Scanner(System.in);
        System.out.println("Mesaj giriniz(Çıkmak için -1)");

        // Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        Producer producer = new KafkaProducer<String, String>(configProperties);
        File file = new File("/home/apricot/Desktop/log.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String msg = null;
        while (true) {
            while ((msg = bufferedReader.readLine()) != null) {
                ProducerRecord<String, String> rec = new ProducerRecord<String, String>(
                        topicName, msg);
                producer.send(rec);

            }
        }


    }
}