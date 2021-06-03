package com.example.demo.service.impl;


import com.example.demo.dao.UserRedPacketDao;
import com.example.demo.entity.RedPacket;
import com.example.demo.entity.UserRedPacket;
import com.example.demo.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {
    private static final int FAILED = 0;
    @Autowired
    private UserRedPacketDao userRedPacketDao;

    private volatile AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 保存抢红包记录
     *
     * @param amt
     * @param userId
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacket1( Long userId,int amt) {

        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setRedPacketId(111L);
        userRedPacket.setUserId(userId);
        userRedPacket.setAmount((double) amt);
        userRedPacket.setNote("抢100红包 "  );
        int result = userRedPacketDao.grapRedPacket(userRedPacket);
        return result;
    }

}
