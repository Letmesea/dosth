package com.rabbitmq.rabbitmq;

import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMulThread implements Runnable{
    List<String> vector = new ArrayList<>();
    static int aures=0;
    public static void main(String [] args) throws InterruptedException {
        int a = Integer.MIN_VALUE+1;
        int cnt =0;
//        AtomicInteger sum = new AtomicInteger(0);
//
//        final CountDownLatch latch = new CountDownLatch(100);
//        for(int i=0;i<100;i++){
//            new Thread(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    aures++;
//
//                    Thread.sleep(10);
//                    System.out.println(Thread.currentThread().getName());
//                    latch.countDown();
//                }
//            }).start();
//        }
//        latch.await();
//        System.out.println("aures: "+aures);
        TestMulThread testMulThread = new TestMulThread();
        TestMulThread testMulThread1 = new TestMulThread();
        Thread t1 = new Thread(testMulThread,"A");
        Thread t2 = new Thread(testMulThread1,"B");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
//        synchronized(this) {
        System.out.println("start : "+aures);
            for (int i = 0; i < 10000; i++) {
//                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
                ++aures;
                System.out.println(Thread.currentThread().getName()+ " do add "+aures);
            }
//        }
//        printInfo(vector);
        System.out.println(Thread.currentThread().getName() + " synchronized loop res: " + aures);
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
