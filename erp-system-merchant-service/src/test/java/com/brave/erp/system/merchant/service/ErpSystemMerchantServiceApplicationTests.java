package com.brave.erp.system.merchant.service;

import com.brave.erp.system.merchant.api.dto.MerchantDto;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.MerchantQueryService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ErpSystemMerchantServiceApplicationTests {

    @Autowired
    private MerchantQueryService merchantQueryService;

    @Test
    void contextLoads() {

        for (int i = 0; i < 5 ;i++){
            BaseResponse<MerchantDto> response = merchantQueryService.queryById(1L);

            System.out.println(response);
        }

        for (int i = 0; i < 5 ;i++){
            BaseResponse<List<MerchantDto>> response = merchantQueryService.queryListByIds(Lists.newArrayList(1L, 2L));

            System.out.println(response);
        }



    }

}
