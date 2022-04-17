package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.dto.MerchantModelDto;
import com.brave.erp.system.merchant.api.request.MerchantQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.response.PageResponse;
import org.apache.dubbo.apidocs.annotations.ApiDoc;
import org.apache.dubbo.apidocs.annotations.ApiModule;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.util.List;

/**
 * 商户查询信息服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:20
 */
@ApiModule(value = "商户查询信息服务", apiInterface = MerchantQueryService.class)
public interface MerchantQueryService {

    @ApiDoc(value = "商户查询")
    BaseResponse<MerchantModelDto> queryById(@RequestParam("入参") MerchantQueryRequest request);

    @ApiDoc(value = "商户批量查询")
    BaseResponse<List<MerchantModelDto>> queryListByIds(List<Long> ids);

    @ApiDoc(value = "分页查询")
    BaseResponse<PageResponse<MerchantModelDto>> queryByPage(List<Long> ids);

}
