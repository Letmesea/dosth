package com.rabbitmqc.rabbitmqc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RabbitmqCApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqCApplication.class, args);
        System.out.println("consumer启动成功");
    }

}
