package com.brave.erp.system.merchant.service.impl;

import com.brave.erp.system.merchant.api.dto.ShopDto;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.enums.ErrCodeEnum;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.ShopQueryService;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import com.brave.erp.system.merchant.service.context.QueryShopContext;
import com.brave.erp.system.merchant.service.context.handle.QueryShopAdaptorHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * 门店服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-18 22:17
 */
@Slf4j
@DubboService
public class ShopQueryServiceImpl implements ShopQueryService {

    private final QueryShopAdaptorHandler queryShopAdaptorHandler;

    public ShopQueryServiceImpl(QueryShopAdaptorHandler queryShopAdaptorHandler) {
        this.queryShopAdaptorHandler = queryShopAdaptorHandler;
    }

    @Override
    @WriteLog("queryShopModelDtoById")
    public BaseResponse<ShopModelDto> queryById(ShopQueryRequest request) {

        try {
            QueryShopContext context = QueryShopContext.init(request);
            queryShopAdaptorHandler.queryShopById(context);
            return BaseResponse.defaultBuildSuccess(context.build());
        } catch (Exception e) {
            log.error("MerchantServiceImpl queryById error,req={}", request, e);
            return BaseResponse.buildError(ErrCodeEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public BaseResponse<List<ShopDto>> queryListByIds(List<Long> ids) {
        return null;
    }
}
