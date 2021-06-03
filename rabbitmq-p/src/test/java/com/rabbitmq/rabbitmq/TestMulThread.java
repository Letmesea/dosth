package com.rabbitmq.rabbitmq;

import java.util.*;

public class TestMulThread implements Runnable{
    List<String> vector = new ArrayList<>();
    public static void main(String [] args){
        int a = Integer.MIN_VALUE+1;
        TestMulThread testMulThread = new TestMulThread();
        TestMulThread testMulThread1 = new TestMulThread();
        Thread t1 = new Thread(testMulThread,"A");
        Thread t2 = new Thread(testMulThread1,"B");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
//        printInfo(vector);
    }
    public void printInfo(List<String> vector){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.get(1);
        for (int i = 0; i < 5; i++) {
            vector.add(i+"");
        }
        for (String s:vector)
            System.out.print(s);
    }
}
