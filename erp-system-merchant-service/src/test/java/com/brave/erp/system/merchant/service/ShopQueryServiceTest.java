package com.brave.erp.system.merchant.service;

import com.brave.erp.system.merchant.api.dto.ShopDto;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.ShopQueryService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 门店查询单测
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-18 22:37
 */
@SpringBootTest
public class ShopQueryServiceTest {

    @Autowired
    private ShopQueryService shopQueryService;

    @Test
    public void queryById() {

        ShopQueryRequest shopQueryRequest = new ShopQueryRequest();
        shopQueryRequest.setShopId(1L);
        shopQueryRequest.setShopDataFields(Lists.newArrayList(ShopDataFieldEnum.BASIC, ShopDataFieldEnum.EXT_PARAM));

        for (int i = 0; i < 3; i++){
            BaseResponse<ShopModelDto> response = shopQueryService.queryById(shopQueryRequest);
            System.out.println(response);
        }

    }

    @Test
    public BaseResponse<List<ShopDto>> queryListByIds(List<Long> ids) {
        return null;
    }
}
