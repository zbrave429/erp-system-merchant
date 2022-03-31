package com.brave.erp.system.merchant.service;

import com.brave.erp.system.merchant.api.dto.MerchantDto;
import com.brave.erp.system.merchant.api.dto.ShopDto;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.enums.MerchantExtParamEnum;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.api.request.CreateMerchantRequest;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.MerchantService;
import com.brave.erp.system.merchant.api.service.ShopQueryService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门店查询单测
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-18 22:37
 */
@SpringBootTest
public class MerchantServiceTest {

    @Autowired
    private MerchantService merchantService;

    @Test
    public void createMerchant() {

        CreateMerchantRequest request = new CreateMerchantRequest();
        request.setMerchantName("自动化测试商户_" + System.currentTimeMillis());
        request.setMerchantType(1);
        request.setAddress("上海市长宁区XXX小区XXX室");
        request.setLat("31.23232");
        request.setLng("120.23231");
        request.setLogo("test.png");
        request.setStatus(0);
        request.setRegisterChannel(0);
        request.setMasterUserId(1L);
        request.setAddBy("brave");

        Map<String, String> extParams = Maps.newHashMap();
        extParams.put(MerchantExtParamEnum.TEST.getCode(), "测试扩展数据");
        extParams.put(MerchantExtParamEnum.TEST2.getCode(), "测试扩展数据2");
        request.setExtParam(extParams);

        BaseResponse<Long> response = merchantService.createMerchant(request);
        System.out.println(response);

    }

    @Test
    public BaseResponse<MerchantDto> updateMerchant(CreateMerchantRequest request) {
        return null;
    }

    @Test
    public BaseResponse<Boolean> removeMerchant(Long id) {
        return null;
    }
}
