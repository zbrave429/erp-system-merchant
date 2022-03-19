package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.dto.ShopDto;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import org.apache.dubbo.apidocs.annotations.ApiDoc;
import org.apache.dubbo.apidocs.annotations.ApiModule;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.util.List;

/**
 * 门店查询服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:21
 */
@ApiModule(value = "门店查询服务", apiInterface = ShopQueryService.class)
public interface ShopQueryService {

    @ApiDoc(value = "根据门店ID查询门店完整信息")
    BaseResponse<ShopModelDto> queryById(@RequestParam(value = "查询请求参数") ShopQueryRequest request);

    @ApiDoc(value = "批量查询门店信息，单次最多支持查询100条记录")
    BaseResponse<List<ShopDto>> queryListByIds(@RequestParam(value = "门店ID列表") List<Long> ids);

}
