package org.abondar.experimental.kafkademo.command;

import org.abondar.experimental.kafkademo.command.impl.Command;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class CustomPartitioningProducerCommand implements Command {


    @Override
    public void execute() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", CommandUtil.KAFKA_HOST);
        properties.put("serializer.class", CommandUtil.SERIALIZER);
        properties.put("request.required.acks", CommandUtil.REQUIRED_ACKS);
        properties.put("key.serializer", CommandUtil.STRING_SERIALIZER);
        properties.put("value.serializer",CommandUtil.STRING_SERIALIZER);
        properties.put("partitioner.class", CommandUtil.PARTITIONER);
        Producer<String, String> producer = new KafkaProducer<>(properties);

        int messageCount = 10;

        System.out.println("Topic " + CommandUtil.TEST_TOPIC);
        System.out.println("Message count " + messageCount);

        Random random = new Random();
        for (int i = 0; i < messageCount; i++) {
            String clientIP = "192.168.14." + random.nextInt(255);
            String accessTime = new Date().toString();

            String msg = accessTime + ",kafka.apache.org," + clientIP;
            System.out.println(msg);
            producer.send(new ProducerRecord<>(CommandUtil.TEST_TOPIC, clientIP,msg));

        }

        producer.close();
    }
}
