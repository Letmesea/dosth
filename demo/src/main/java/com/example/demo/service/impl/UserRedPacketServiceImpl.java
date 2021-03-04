package com.example.demo.service.impl;

import com.example.demo.dao.RedPacketDao;
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
    @Autowired
    private RedPacketDao redPacketDao;
    private volatile AtomicInteger atomicInteger = new AtomicInteger(0);
    /**
     * 保存抢红包的信息
     * @param redPacketId 红包编号
     * @param userId 抢红包的用户编号
     * @return 影响记录数目
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long userId){
        RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
        //当前小红包库存大于0
        if(redPacket.getStock() > 0){
            redPacketDao.decreaseRedPacket(redPacketId);
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("抢红包 "+redPacketId);
            int result = userRedPacketDao.grapRedPacket(userRedPacket);
            return result;
        }
        return FAILED;
    }
}
