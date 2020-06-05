package com.rabbitmqc.rabbitmqc.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Letmesea
 * @title: Shop
 * @projectName dosth
 * @description: TODO
 * @date 2020/6/513:49
 */
public class Shop {
    private String name;
    Shop(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 模拟某个耗时操作
     * @param product
     * @return
     * @throws InterruptedException
     */
    public double getPrice(String product) throws InterruptedException {
        Thread.sleep(1000);
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
    public static void main(String[] args){
        List<Shop> shops = Arrays.asList(
                new Shop("one"),
                new Shop("two"),
                new Shop("three"),
                new Shop("four"));
        //异步处理示例
        List<CompletableFuture<String>> str2 = shops.stream().map(shop->
                CompletableFuture.supplyAsync(
                        ()-> {
                            try {
                                return String.format("%s price: %.2f", shop.getName(), shop.getPrice(shop.getName()));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return null;
                        })).collect(Collectors.toList());
    }
}
