package com.dahuzi.springboot_study.redis.listener.api;

import com.dahuzi.springboot_study.redis.listener.servie.MessageListenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 18:00
 * @since JDK 1.8
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class MessageListenterApi
{
    @Autowired
    private MessageListenterService messageListenterService;

    @RequestMapping("/send/message")
    public boolean sendMessage(String message)
    {
        return messageListenterService.pushMessadge(message);
    }

}