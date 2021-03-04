package com.example.demo.service;

import com.example.demo.entity.RedPacket;

import java.util.List;

public interface RedPacketService {
    List<RedPacket> getRedPacketList();
    public RedPacket getRedPacket(Long id);
    public int decreaseRedPacket(Long id);
}
