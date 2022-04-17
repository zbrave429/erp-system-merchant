package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.request.ShopQueryListRequest;
import com.brave.erp.system.merchant.api.request.ShopQueryPageRequest;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.response.PageResponse;
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

    @ApiDoc("根据门店ID查询门店完整信息")
    BaseResponse<ShopModelDto> queryById(@RequestParam("查询请求参数") ShopQueryRequest request);

    @ApiDoc("批量查询门店信息，单次最多支持查询100条记录")
    BaseResponse<List<ShopModelDto>> queryListByIds(@RequestParam("查询请求参数")ShopQueryListRequest request);

    @ApiDoc("分页查询")
    BaseResponse<PageResponse<ShopModelDto>> queryByPage(@RequestParam("查询请求参数")ShopQueryPageRequest request);

}
