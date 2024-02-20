package com.example.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class SimpleProducer {

  public static void main(String[] args) {

    // 토픽 이름 지정
    String topicName = "simple-topic";

    // KafkaProducer configuration setting
    // key값은 null, value는 "hello world"

    Properties props = new Properties();
    // bootstrap.servers, key.serializer.class, value.serializer.class
    props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
    props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // KafkaProducer 객체 생성
    KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);

    // ProducerRecord 객체 생성
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName, "id-001", "hello world2");

    // KafkaProducer message send
    kafkaProducer.send(producerRecord);

    // KafkaProducer 종료
    kafkaProducer.flush();
    kafkaProducer.close();

  }
}
