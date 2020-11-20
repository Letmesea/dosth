package com.rabbitmq.rabbitmq;

import com.rabbitmq.rabbitmq.dto.A;
import com.rabbitmq.rabbitmq.dto.B;
import com.rabbitmq.rabbitmq.dto.C;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMerge2List {
    public static void main(String [] args){
        BigDecimal aa = BigDecimal.ONE;
        String ba = aa.toString();
        List<A> as = new ArrayList<>();
        as.add(new A("7860","400"));
        as.add(new A("7401","200"));

        List<B> bs = new ArrayList<>();
        bs.add(new B("7860","300"));
//        bs.add(new B("7401","100"));

        List<C> cs = new ArrayList<>();
        for (A a : as) {
            C c = new C();
            c.setChannel(a.getChannel());
            c.setPayAmount(a.getPayAmount());
            boolean bln = false;
            for (B b : bs) {
                if (a.getChannel().equals(b.getChannel())) {
                    c.setRefundAmount(b.getRefundAmount());
                    bln = true;
                    break;
                }
            }
            if (!bln) {
                c.setRefundAmount("0");
            }
            cs.add(c);
        }
        System.out.println(1);
    }
}
