package com.example.demo.controller;

import com.example.demo.entity.UserRedPacket;
import com.example.demo.service.UserRedPacketService;
import com.example.demo.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 抢红包，集群考虑使用redis操作
 */
@Controller
@RequestMapping("/userRedPacket")
@Slf4j
public class UserRedPacketController {
    @Autowired
    private UserRedPacketService userRedPacketService;

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 初始化红包金额
     */
    @PostConstruct
    public void initRedPackAmount(){
        //没有初始化就初始化
        redisTemplate.opsForValue().setIfAbsent("amount",100);
        log.info("初始化红包金额成功，金额"+redisUtils.get("amount").toString());
    }

    /**
     * 抢红包接口,多人抢红包，抢完为止（已接口形式展现，抢到金额随机，
     * 未抢到返回0，请考虑集群部署的情况，建表保存抢红包的记录，限定每个人只能抢一次，按照抢到金额多少输出	列表）
     * @return
     */
    @GetMapping(value = "/grapRedPacket/{userId}")
    @ResponseBody
    public Integer grapRedPacket666(@PathVariable Long userId){
        try {
            //10块以下金额随机金额
            Random result = new Random();
            int am = result.nextInt(10+1);
            Boolean again = redisTemplate.opsForValue().setIfAbsent(userId+"", userId);
            if (again==null||!again){
                log.warn("每个人只能抢1次:"+userId);
                return 0;
            }
            boolean getlock = redisUtils.getLock(10 * 1000);
            if (getlock){
                //锁
                int remain = Integer.parseInt(redisUtils.get("amount").toString());
                if (remain>am){
                    redisTemplate.opsForValue().set("amount",remain-am);
                    //抢到释放
                    redisUtils.releaseLock();
                    //保存记录
                    userRedPacketService.grapRedPacket1(userId,am);
                    return am;
                }else{
                    return 0;
                }
            }
            return 0;
        }catch (Exception e){
            log.error("失败",e);
        }
        return 0;
    }


}
