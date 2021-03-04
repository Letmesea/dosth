package com.example.demo.dao;

import com.example.demo.entity.UserRedPacket;
import org.apache.ibatis.annotations.Insert;

public interface UserRedPacketDao {
    @Insert("insert into T_USER_RED_PACKET(red_packet_id,user_id,amount,grab_time,note) values(#{redPacketId},#{userId},#{amount},now(),#{note})")
    public int grapRedPacket(UserRedPacket userRedPacket);
}
