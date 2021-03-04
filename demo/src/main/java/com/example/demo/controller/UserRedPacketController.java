package com.example.demo.controller;

import com.example.demo.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 抢红包，集群考虑使用redis分布式锁，只有获得锁的才能进行扣减
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {
    @Autowired
    private UserRedPacketService userRedPacketService;

    @RequestMapping(value = "/grapRedPacket")
    @ResponseBody
    public Map<String,Object> grapRedPacket(Long redPacketId, Long userId){
        //抢红包
        int result = userRedPacketService.grapRedPacket(redPacketId,userId);
        Map<String,Object> retMap = new HashMap<>();
        boolean flag = result>0;
        retMap.put("success",flag);
        retMap.put("message",flag?"抢红包":"抢红包失败");
        return retMap;
    }
    @RequestMapping("/1")
    public String test(){
        return "grap";
    }
}
