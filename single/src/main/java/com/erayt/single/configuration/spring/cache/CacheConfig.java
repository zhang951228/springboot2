package com.erayt.single.configuration.spring.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 摘抄过来的redis 缓存相关，因暂时没有redis，代码注视掉。
 */
/*@Configuration
@EnableCaching*/
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * spring boot redis默认序列化方式
     *
     * @return RedisTemplate
     */
/*    @Bean
    public simpleTemplate<String, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    *//**
     * spring redis 默认生成key方式,包含::号
     *
     * @param prefix
     * @param key
     * @return
     *//*
    public String simpleKeyGenerator(String prefix, String key) {
        return CacheKeyPrefix.simple().compute(prefix) + key;
    }*/
}
