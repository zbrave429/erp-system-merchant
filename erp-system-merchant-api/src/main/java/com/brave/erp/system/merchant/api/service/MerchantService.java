package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.request.CreateMerchantRequest;
import com.brave.erp.system.merchant.api.request.UpdateMerchantRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import org.apache.dubbo.apidocs.annotations.ApiDoc;
import org.apache.dubbo.apidocs.annotations.ApiModule;

/**
 * 商户数据维护服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-30 19:59
 */
@ApiModule(value = "商户数据维护服务", apiInterface = MerchantService.class)
public interface MerchantService {

    /**
     * 创建商户
     * @param request
     * @return
     */
    @ApiDoc("创建商户")
    BaseResponse<Long> createMerchant(CreateMerchantRequest request);

    /**
     * 更新商户
     * @param request
     * @return
     */
    @ApiDoc("更新商户")
    BaseResponse<Boolean> updateMerchant(UpdateMerchantRequest request);

    /**
     * 删除商户
     * @param id
     * @return
     */
    @ApiDoc("删除商户")
    BaseResponse<Boolean> removeMerchant(Long id);

}
