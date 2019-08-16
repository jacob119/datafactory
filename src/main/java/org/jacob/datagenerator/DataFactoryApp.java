package org.jacob.datagenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.jacob.datagenerator.factory.SensorDataFactory;
import org.jacob.datagenerator.schedule.DynamicScheduler;
import org.jacob.datagenerator.schedule.SchedulerActor;
import org.jacob.datagenerator.schedule.SchedulerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@Slf4j
public class DataFactoryApp implements ApplicationRunner {

    @Autowired
    SensorDataFactory sensorDataFactory;

    @Autowired
    SchedulerManager schedulerManager;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DataFactoryApp.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DynamicScheduler dynamicScheduler = new DynamicScheduler("sensor-data", 1, new SchedulerActor() {
            @Override
            public void doTask() {
                send("test", sensorDataFactory.getJson());
            }
        });
        schedulerManager.add(dynamicScheduler);
        schedulerManager.startAll();
    }

    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
        log.info("Message: " + payload + " sent to topic: " + topic);
    }
}