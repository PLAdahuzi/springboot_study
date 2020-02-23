package com.dahuzi.springboot_study.redis;

import com.dahuzi.springboot_study.SpringbootStudyApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 16:06
 * @since JDK 1.8
 */
public class RedisConnectionTest extends SpringbootStudyApplicationTests
{
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void redisConnectionTest()
    {
        Map<String, Object> properties = new HashMap<>();
        properties.put("123", "hello");
        properties.put("abc", 456);

        redisTemplate.opsForHash().putAll("hash", properties);

        Map<Object, Object> ans = redisTemplate.opsForHash().entries("hash");
        System.out.println("ans: " + ans);
    }

}