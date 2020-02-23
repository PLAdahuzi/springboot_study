package com.dahuzi.springboot_study.redis.listener.config;

import com.dahuzi.springboot_study.redis.listener.common.RedisListenterCommon;
import com.dahuzi.springboot_study.redis.listener.consumer.RedisConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 18:12
 * @since JDK 1.8
 */
@Configuration
public class RedisListenterConfig
{
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter)
    {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        //可以添加多个 messageListener
        container.addMessageListener(listenerAdapter, new PatternTopic(RedisListenterCommon.TOPIC));

        return container;
    }

    /**
     * 消息监听器适配器，绑定消息处理器，利用反射技术调用消息处理器的业务方法
     *
     * @param redisReceiver
     * @return
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisConsumer redisReceiver)
    {
        System.out.println("消息适配器进来了");
        return new MessageListenerAdapter(redisReceiver, "onMessage");
    }
}