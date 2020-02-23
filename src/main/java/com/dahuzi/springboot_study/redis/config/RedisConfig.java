package com.dahuzi.springboot_study.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author mjye
 * @version 1.0, 2020/2/23 13:58
 * @since JDK 1.8
 */
@Configuration
public class RedisConfig extends JCacheConfigurerSupport
{
    //    @Autowired
    //    private DefaultStrSerializer defaultStrSerializer;

    @Value("${spring.redis.host:localhost}")
    private String host;
    @Value("${spring.redis.port:6379}")
    private int port;
    @Value("${spring.redis.password:}")
    private String password;
    @Value("${spring.redis.timeout:10000}")
    private int timeout;
    @Value("${spring.redis.database:0}")
    private int database;

    @Value("${spring.redis.pool.maxTotal:8}")
    private int maxTotal;
    @Value("${spring.redis.pool.max-wait:-1}")
    private long maxWait;
    @Value("${spring.redis.pool.min-idle:0}")
    private int minIdle;
    @Value("${spring.redis.pool.max-idle:8}")
    private int maxIdle;
    @Value("${spring.redis.pool.min-evictable-idle-time:1800000}")
    private int minEvictableIdleTime;
    @Value("${spring.redis.pool.num-tests-per-eviction-run:3}")
    private int numTestsPerEvictionRun;
    @Value("${spring.redis.pool.time-between-eviction-runs-millis:30000}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.redis.pool.test-on-borrow:false}")
    private boolean testOnBorrow;
    @Value("${spring.redis.pool.test-while-idle:false}")
    private boolean testWhileIdle;
    @Value("${spring.redis.pool.test-on-create:false}")
    private boolean testOnCreate;
    @Value("${spring.redis.pool.test-on-return:false}")
    private boolean testOnReturn;
    @Value("${spring.redis.pool.block-when-exhausted:true}")
    private boolean blockWhenExhausted;
    @Value("${spring.redis.pool.jmx-enabled:true}")
    private boolean jmxEnabled;
    @Value("${spring.redis.pool.jmx-name-base:}")
    private String jmxNameBase;
    @Value("${spring.redis.pool.jmx-name-prefix:pool}")
    private String jmxNamePrefix;

    @Bean
    public RedisConnectionFactory redisConnectionFactory()
    {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTime);
        poolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        poolConfig.setTestOnCreate(testOnCreate);
        poolConfig.setTestOnBorrow(testOnBorrow);
        poolConfig.setTestOnReturn(testOnReturn);
        poolConfig.setTestWhileIdle(testWhileIdle);
        poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        poolConfig.setBlockWhenExhausted(blockWhenExhausted);
        poolConfig.setJmxEnabled(jmxEnabled);
        poolConfig.setJmxNameBase(jmxNameBase);
        poolConfig.setJmxNamePrefix(jmxNamePrefix);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setDatabase(database);
        factory.setHostName(host);
        factory.setPassword(password);
        factory.setPort(port);
        factory.setTimeout(timeout);
        factory.setPoolConfig(poolConfig);
        return factory;
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer()
    {
        return new StringRedisSerializer();
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory,
            DefaultStrSerializer defaultStrSerializer)
    {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(defaultStrSerializer);
        redisTemplate.setValueSerializer(defaultStrSerializer);
        redisTemplate.setHashKeySerializer(defaultStrSerializer);
        redisTemplate.setHashValueSerializer(defaultStrSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}