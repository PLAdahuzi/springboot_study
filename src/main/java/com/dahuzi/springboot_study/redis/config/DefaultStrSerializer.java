package com.dahuzi.springboot_study.redis.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 16:49
 * @since JDK 1.8
 */
@Component
public class DefaultStrSerializer implements RedisSerializer<Object>
{
    private final Charset charset;

    public DefaultStrSerializer() {
        this(StandardCharsets.UTF_8);
    }

    public DefaultStrSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }


    @Override
    public byte[] serialize(Object o) throws SerializationException
    {
        return o == null ? null : String.valueOf(o).getBytes(charset);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return bytes == null ? null : new String(bytes, charset);

    }
}