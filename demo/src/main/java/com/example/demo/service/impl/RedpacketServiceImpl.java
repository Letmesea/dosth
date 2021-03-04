package com.example.demo.service.impl;

import com.example.demo.dao.RedPacketDao;
import com.example.demo.entity.RedPacket;
import com.example.demo.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RedpacketServiceImpl implements RedPacketService {

    @Autowired
    private RedPacketDao redPacketDao;
    @Override
    public List<RedPacket> getRedPacketList(){
//        return redPacketDao.getList();
        return null;
    }
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id) {
        return redPacketDao.getRedPacket(id);
    }
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id) {
        return redPacketDao.decreaseRedPacket(id);
    }
}
