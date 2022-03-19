package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.dto.MerchantDto;
import com.brave.erp.system.merchant.api.response.BaseResponse;

import java.util.List;

/**
 * 商户信息服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:20
 */
public interface MerchantQueryService {

    BaseResponse<MerchantDto> queryById(Long id);

    BaseResponse<List<MerchantDto>> queryListByIds(List<Long> ids);

}
