package com.example.demo.dao;

import com.example.demo.entity.RedPacket;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RedPacketDao {
    /**
     * 获取红包信息,这里暂时使用悲观锁实现  //for update
     * @param id 红包 id
     * @return 红包具体信息
     */
    @Select("select id, user_id as userId,amount,send_date as sendDate,total,unit_amount as unitAmount,stock,version,note from t_red_packet where id=#{id} for update")
    public RedPacket getRedPacket(Long id);

    /**
     * 扣减抢红包数
     * @param id 红包id
     * @return 更新记录条数
     */
    @Update("update t_red_packet set stock = stock-1 where id = #{id}")
    public int decreaseRedPacket(Long id);


}
