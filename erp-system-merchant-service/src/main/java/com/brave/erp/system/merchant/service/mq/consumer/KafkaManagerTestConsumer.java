package com.brave.erp.system.merchant.service.mq.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaManagerTestConsumer
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-03 22:48
 */
@Component
@Slf4j
public class KafkaManagerTestConsumer {

    @KafkaListener(topics = "kafka_manager_test", groupId = "erp.system.merchant-order-center.consumer")
    public void onMessage(ConsumerRecord<?, ?> record){
        log.info("massage={}, body={}", JSON.toJSONString(record), record.value());
    }


}
