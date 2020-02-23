package com.dahuzi.springboot_study.redis.listener.servie;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 17:55
 * @since JDK 1.8
 */
public interface MessageListenterService
{
    /**
     * [简要描述]: 发送消息
     * [详细描述]:
     * @param message : 消息内容
     * @return boolean
     * mjye  2020/2/23 - 17:57
     **/
    boolean pushMessadge(String message);
}
