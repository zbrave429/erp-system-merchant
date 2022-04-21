package com.brave.erp.system.merchant.service;

import com.brave.dubbo.trace.IdGenEnum;
import com.brave.dubbo.trace.TraceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-21 13:16
 */
@SpringBootTest
@Slf4j
public class BaseTest {

    @BeforeAll
    static void before(){

        // 初始化trace
        TraceContext.init(IdGenEnum.UUID, "");
        log.info("tracer init ,{}", TraceContext.get());

    }


}
