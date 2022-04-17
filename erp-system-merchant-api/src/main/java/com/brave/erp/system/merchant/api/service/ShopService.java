package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.request.CreateShopRequest;
import com.brave.erp.system.merchant.api.request.UpdateShopRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import org.apache.dubbo.apidocs.annotations.ApiDoc;
import org.apache.dubbo.apidocs.annotations.ApiModule;

/**
 * 门店数据维护服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 20:10
 */
@ApiModule(value = "门店数据维护服务", apiInterface = ShopService.class)
public interface ShopService {

    @ApiDoc("创建门店")
    BaseResponse<Long> createShop(CreateShopRequest request);

    @ApiDoc(value = "更新门店")
    BaseResponse<Long> updateShop(UpdateShopRequest request);

    @ApiDoc(value = "删除门店")
    BaseResponse<Boolean> removeShop(Long id);

}
