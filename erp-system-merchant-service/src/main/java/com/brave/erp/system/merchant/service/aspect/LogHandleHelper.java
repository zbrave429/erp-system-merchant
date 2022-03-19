package com.brave.erp.system.merchant.service.aspect;

import com.alibaba.fastjson.JSON;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 接口日志输出
 */
@Slf4j
@Component
@Aspect
public class LogHandleHelper {

    @Around(value = "execution(public * com.brave.erp..*.*(..)) && @annotation(writeLog)")
    public Object writeLog(ProceedingJoinPoint point, WriteLog writeLog) throws Throwable {

        String logName = StringUtils.defaultString(writeLog.value(), point.getSignature().getName());

        long startTime = System.currentTimeMillis();
        try {
            Object result = point.proceed();
            log.info("方法:[{}] 耗时:{}ms 执行结果:[{}] req:{}, resp:{}",
                    logName,
                    (System.currentTimeMillis() - startTime),
                    Boolean.TRUE,
                    JSON.toJSONString(point.getArgs()),
                    JSON.toJSONString(result));
            return result;
        } catch (Throwable e) {
            log.error("方法:[{}] 耗时:{}ms 执行结果:[{}] req:{}",
                    logName,
                    (System.currentTimeMillis() - startTime),
                    Boolean.FALSE,
                    JSON.toJSONString(point.getArgs()),
                    e);
            throw e;
        }
    }

}
