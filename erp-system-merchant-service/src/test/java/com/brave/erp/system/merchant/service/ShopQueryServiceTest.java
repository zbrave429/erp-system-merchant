package com.brave.erp.system.merchant.service;

import com.brave.erp.system.merchant.api.dto.OrderByField;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.enums.OrderByTypeEnum;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.api.enums.ShopOrderByEnum;
import com.brave.erp.system.merchant.api.request.ShopQueryListRequest;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.ShopQueryService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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
    public void queryListByIds() {
        ShopQueryListRequest request = new ShopQueryListRequest();
        request.setShopIds(Lists.newArrayList(1L));
        List<OrderByField> orderByFields = Lists.newArrayList(
                OrderByField.asc(ShopOrderByEnum.UPDATE_TIME.name()),
                OrderByField.desc(ShopOrderByEnum.ID.name()),
                OrderByField.asc(ShopOrderByEnum.ADD_TIME.name()));

        request.setOrderByFields(orderByFields);
        request.setShopDataFields(Lists.newArrayList(ShopDataFieldEnum.BASIC));

        BaseResponse<List<ShopModelDto>> response = shopQueryService.queryListByIds(request);

        System.out.println(response);


    }
}
