package com.brave.erp.system.merchant.service.config;

import cn.ygzhangmfh.util.task.AsyncConfig;
import cn.ygzhangmfh.util.task.AsyncFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 本地延时任务配置
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 23:06
 */
@Component
@ConfigurationProperties(prefix = "asynctask")
@Data
public class AsyncTaskConfig {

    private int timeout;

    private String threadPrefix;

    @PostConstruct
    private void init() {
        AsyncConfig asyncConfig = new AsyncConfig(timeout, threadPrefix);
        AsyncFactory.init(asyncConfig);
    }

    @PreDestroy
    private void destroy() {
        AsyncFactory.destroy();
    }

}
