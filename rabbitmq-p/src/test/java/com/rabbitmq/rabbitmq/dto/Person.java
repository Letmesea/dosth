package com.rabbitmq.rabbitmq.dto;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String mail;
    private Integer age;
    private String sex;
    public Person(String name,String mail,int age,String sex){
        this.name = name;
        this.mail = mail;
        this.age= age;
        this.sex = sex;
    }
    public void printInfo(String prm){
        System.out.println(prm);
    }
}
