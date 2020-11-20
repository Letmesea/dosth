package com.rabbitmq.rabbitmq;

public class TestMulThread {
    public static void main(String [] args){
        asyncWork();
        System.out.println(111);
    }
    public static void asyncWork(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("currThread: "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
