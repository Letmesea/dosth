package com.rabbitmq.rabbitmq.util;

/**
 * 测试classLoader
 */
public class ClassLoader {
    public static void main(String[] args) {
        //从类的包下查找
        System.out.println(ClassLoader.class.getResource("12.html"));
        //从classpath下获取,必须‘/’开头
        System.out.println(ClassLoader.class.getResource("/12.html"));
        System.out.println();
        //在classpath 下获取,不用带'/'
        System.out.println(ClassLoader.class.getClassLoader().getResource("12.html"));
        //null
        System.out.println(ClassLoader.class.getClassLoader().getResource("/12.html"));
    }
}
