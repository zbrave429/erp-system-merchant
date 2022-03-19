package com.brave.erp.system.merchant.service.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "redisson")
@Data
public class RedisClientConfig {

    private String address;
    private int timeout;
    private int database;

    @Bean
    public RedissonClient getRedisClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress(address)
                .setDatabase(database)
                .setTimeout(timeout);
        return Redisson.create(config);
    }

}