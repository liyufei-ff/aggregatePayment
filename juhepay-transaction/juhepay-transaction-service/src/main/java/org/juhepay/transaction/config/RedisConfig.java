package org.juhepay.transaction.config;

import org.juhepay.common.cache.Cache;
import org.juhepay.transaction.common.util.RedisCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName RedisConfig
 * @Description
 * @Author lily
 * @Date 2021/1/26 11:40 上午
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public Cache cache(StringRedisTemplate stringRedisTemplate){
        return new RedisCache(stringRedisTemplate);
    }
}