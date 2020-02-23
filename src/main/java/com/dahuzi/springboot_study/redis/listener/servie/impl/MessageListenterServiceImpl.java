package com.dahuzi.springboot_study.redis.listener.servie.impl;

import com.dahuzi.springboot_study.redis.listener.common.RedisListenterCommon;
import com.dahuzi.springboot_study.redis.listener.servie.MessageListenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 17:55
 * @since JDK 1.8
 */
@Slf4j
@Service
public class MessageListenterServiceImpl implements MessageListenterService
{

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean pushMessadge(String message)
    {
        try
        {
            redisTemplate.convertAndSend(RedisListenterCommon.TOPIC, message);
            return true;
        }
        catch (Exception e)
        {
            log.error("发送消息异常", e);
            return false;
        }
    }
}