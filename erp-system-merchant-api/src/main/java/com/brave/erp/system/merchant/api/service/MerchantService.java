package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.request.CreateMerchantRequest;
import com.brave.erp.system.merchant.api.request.UpdateMerchantRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;

/**
 * 商户联机操作服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-30 19:59
 */
public interface MerchantService {

    /**
     * 创建商户
     * @param request
     * @return
     */
    BaseResponse<Long> createMerchant(CreateMerchantRequest request);

    /**
     * 更新商户
     * @param request
     * @return
     */
    BaseResponse<Boolean> updateMerchant(UpdateMerchantRequest request);

    /**
     * 删除商户
     * @param id
     * @return
     */
    BaseResponse<Boolean> removeMerchant(Long id);

}
