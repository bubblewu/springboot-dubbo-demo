package com.bubble.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@EnableDubbo(scanBasePackages = "com.bubble.consumer.controller")
//@PropertySource("classpath:application.properties")
//@ComponentScan(value = {"com.bubble.consumer.controller"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
