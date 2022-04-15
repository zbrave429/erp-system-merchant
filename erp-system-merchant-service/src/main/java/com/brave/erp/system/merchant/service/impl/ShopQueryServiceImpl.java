package com.brave.erp.system.merchant.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.brave.erp.system.merchant.api.dto.ShopDto;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.enums.ErrCodeEnum;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.api.request.ShopQueryListRequest;
import com.brave.erp.system.merchant.api.request.ShopQueryPageRequest;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.response.PageResponse;
import com.brave.erp.system.merchant.api.service.ShopQueryService;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import com.brave.erp.system.merchant.service.context.QueryShopContext;
import com.brave.erp.system.merchant.service.context.handle.QueryShopAdaptorHandler;
import com.brave.erp.system.merchant.service.domain.Shop;
import com.brave.erp.system.merchant.service.domain.ShopExtParam;
import com.brave.erp.system.merchant.service.mapper.ShopExtParamMapper;
import com.brave.erp.system.merchant.service.mapper.ShopMapper;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

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

    private final ShopMapper shopMapper;

    private final ShopExtParamMapper shopExtParamMapper;

    public ShopQueryServiceImpl(QueryShopAdaptorHandler queryShopAdaptorHandler,
                                ShopMapper shopMapper,
                                ShopExtParamMapper shopExtParamMapper) {
        this.queryShopAdaptorHandler = queryShopAdaptorHandler;
        this.shopMapper = shopMapper;
        this.shopExtParamMapper = shopExtParamMapper;
    }

    /**
     * 通过适配器 + context方式实现
     * @param request 入参
     * @return 响应
     */
    @Override
    @WriteLog("queryShopModelDtoById")
    public BaseResponse<ShopModelDto> queryById(ShopQueryRequest request) {

        try {
            // 初始化上下文信息
            QueryShopContext context = QueryShopContext.init(request);
            // 执行查询
            queryShopAdaptorHandler.queryShopById(context);
            return BaseResponse.defaultBuildSuccess(context.build());
        } catch (Exception e) {
            log.error("MerchantServiceImpl queryById error,req={}", request, e);
            return BaseResponse.buildError(ErrCodeEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public BaseResponse<List<ShopModelDto>> queryListByIds(ShopQueryListRequest request) {

        List<Long> shopIds = request.getShopIds();

        List<ShopDataFieldEnum> shopDataFields = request.getShopDataFields();

        List<ShopModelDto> result = Lists.newArrayList();

        // 基础信息
        Map<Long, ShopDto> shopDtoMap = Maps.newHashMap();
        if(shopDataFields.contains(ShopDataFieldEnum.BASIC)){
            // 构造排序字符串
            if(CollectionUtils.isNotEmpty(request.getOrderByFields())){
                StringBuilder stringBuilder = new StringBuilder();
                request.getOrderByFields().forEach(
                        orderByField -> stringBuilder.append(orderByField.getFieldName())
                                .append(" ")
                                .append(orderByField.getOrderByType().name())
                                .append(","));
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                PageHelper.orderBy(stringBuilder.toString());
            }
            List<Shop> shopList = shopMapper.selectByIds(shopIds);

            shopList.forEach(shop -> {
                ShopDto shopDto = new ShopDto();
                BeanUtils.copyProperties(shop, shopDto);
                shopDtoMap.put(shop.getId(), shopDto);
            });
        }

        // 扩展数据
        Map<Long, Map<String, String>> shopExtParamMap = Maps.newHashMap();
        if(shopDataFields.contains(ShopDataFieldEnum.EXT_PARAM)){
            List<ShopExtParam> shopExtParams = shopExtParamMapper.selectListByShopIds(shopIds);
            shopExtParams.forEach(shopExtParam -> {
                if(shopExtParamMap.containsKey(shopExtParam.getShopId())){
                    shopExtParamMap.get(shopExtParam.getShopId()).put(shopExtParam.getExtCode(), shopExtParam.getExtValue());
                } else {
                    Map<String, String> extParam = Maps.newHashMap();
                    extParam.put(shopExtParam.getExtCode(), shopExtParam.getExtValue());
                    shopExtParamMap.put(shopExtParam.getShopId(), extParam);
                }
            });
        }

        // 组装数据
        for(Long shopId: shopIds){
            if (!shopDtoMap.containsKey(shopId) && !shopExtParamMap.containsKey(shopId)){
                continue;
            }

            ShopModelDto shopModelDto = new ShopModelDto();
            shopModelDto.setShopId(shopId);
            shopModelDto.setShopDto(shopDtoMap.get(shopId));
            shopModelDto.setExtParam(shopExtParamMap.get(shopId));
            result.add(shopModelDto);
        }

        return BaseResponse.defaultBuildSuccess(result);
    }

    @Override
    public BaseResponse<PageResponse<ShopModelDto>> queryPage(ShopQueryPageRequest request) {
        return null;
    }


}
