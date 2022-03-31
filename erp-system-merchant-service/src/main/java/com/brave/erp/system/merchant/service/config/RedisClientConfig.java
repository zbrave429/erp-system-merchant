package com.brave.erp.system.merchant.service.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redis 通过配置中心自动配置
 */
@Configuration
@NacosPropertySource(dataId = "redis-config", autoRefreshed = true,
        properties = @NacosProperties(namespace = "frame_global_config"))
@Data
@Slf4j
public class RedisClientConfig {

    @NacosValue(value = "${redisson.address:redis://127.0.0.1:6379}", autoRefreshed = true)
    private String address;

    @NacosValue(value = "${redisson.timeout:1000}", autoRefreshed = true)
    private int timeout;

    @NacosValue(value = "${redisson.database:0}", autoRefreshed = true)
    private int database;

    @NacosValue(value = "${redisson.password:123456}", autoRefreshed = true)
    private String password;

    @Bean
    public RedissonClient getRedisClient(){
        log.info("init redis useSingleServer, address={}, timeout={}, database={}", address, timeout, database);
        Config config = new Config();
        config.useSingleServer()
                .setAddress(address)
                .setDatabase(database)
                .setTimeout(timeout)
                .setPassword(password);
        return Redisson.create(config);
    }

}