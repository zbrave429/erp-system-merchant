package com.brave.erp.system.merchant.service.config;

import com.brave.dubbo.trace.thread.AsyncTaskFactory;
import com.brave.dubbo.trace.thread.ThreadPoolConfig;
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
public class AsyncTaskFactoryConfig {

    private int timeout;

    private String threadPrefix;

    @PostConstruct
    private void init() {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig(timeout, threadPrefix);
        AsyncTaskFactory.init(threadPoolConfig);
    }

    @PreDestroy
    private void destroy() {
        AsyncTaskFactory.destroy();
    }

}
