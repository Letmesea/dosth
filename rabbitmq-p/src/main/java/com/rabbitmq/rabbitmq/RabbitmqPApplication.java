package com.rabbitmq.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RabbitmqPApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqPApplication.class, args);
        System.out.println("provider启动成功");
    }

}
