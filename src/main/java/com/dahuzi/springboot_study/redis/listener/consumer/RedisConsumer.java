package com.dahuzi.springboot_study.redis.listener.consumer;

import org.springframework.stereotype.Component;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 18:03
 * @since JDK 1.8
 */
@Component
public class RedisConsumer
{
    public void onMessage(String message)
    {
        System.out.println("我收到消息：" + message);
    }
}