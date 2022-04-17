package com.brave.erp.system.merchant.service.impl;

import com.brave.erp.system.merchant.api.request.CreateShopRequest;
import com.brave.erp.system.merchant.api.request.UpdateShopRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 21:23
 */
@Slf4j
@DubboService
public class ShopServiceImpl implements ShopService {

    @Override
    public BaseResponse<Long> createShop(CreateShopRequest request) {
        return null;
    }

    @Override
    public BaseResponse<Long> updateShop(UpdateShopRequest request) {
        return null;
    }

    @Override
    public BaseResponse<Boolean> removeShop(Long id) {
        return null;
    }
}
