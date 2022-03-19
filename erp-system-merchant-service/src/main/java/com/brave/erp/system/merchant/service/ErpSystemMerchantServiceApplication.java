package com.brave.erp.system.merchant.service;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ErpSystemMerchantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpSystemMerchantServiceApplication.class, args);
    }

}
