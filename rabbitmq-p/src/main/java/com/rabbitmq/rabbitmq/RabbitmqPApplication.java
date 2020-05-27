package com.rabbitmq.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqPApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqPApplication.class, args);
        System.out.println("provider启动成功");
    }

}
