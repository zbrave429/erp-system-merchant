package com.brave.erp.system.merchant.service.impl;

import com.brave.erp.system.merchant.api.request.CreateShopRequest;
import com.brave.erp.system.merchant.api.request.UpdateShopRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.ShopService;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import com.brave.erp.system.merchant.service.domain.Shop;
import com.brave.erp.system.merchant.service.domain.ShopExtParam;
import com.brave.erp.system.merchant.service.mapper.ShopExtParamMapper;
import com.brave.erp.system.merchant.service.mapper.ShopMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 门店数据维护
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 21:23
 */
@Slf4j
@DubboService
@Service
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;

    private final ShopExtParamMapper shopExtParamMapper;

    public ShopServiceImpl(ShopMapper shopMapper, ShopExtParamMapper shopExtParamMapper) {
        this.shopMapper = shopMapper;
        this.shopExtParamMapper = shopExtParamMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @WriteLog("createShop")
    public BaseResponse<Long> createShop(CreateShopRequest request) {

        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);

        shopMapper.insertSelective(shop);

        if (!CollectionUtils.isEmpty(request.getExtParam())){
            List<ShopExtParam> extParams = request.getExtParam().entrySet().stream()
                    .map(entry -> new ShopExtParam(shop.getId(), entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
            shopExtParamMapper.batchInsert(extParams);
        }

        return BaseResponse.defaultBuildSuccess(shop.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @WriteLog("updateShop")
    public BaseResponse<Long> updateShop(UpdateShopRequest request) {

        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);

        shopMapper.updateByPrimaryKeySelective(shop);

        if (!CollectionUtils.isEmpty(request.getExtParam())){

            shopExtParamMapper.deleteByShopIdAndCode(shop.getId(), Lists.newArrayList(request.getExtParam().keySet()));

            List<ShopExtParam> extParams = request.getExtParam().entrySet().stream()
                    .map(entry -> new ShopExtParam(shop.getId(), entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());
            shopExtParamMapper.batchInsert(extParams);
        }


        return BaseResponse.defaultBuildSuccess(shop.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @WriteLog("removeShop")
    public BaseResponse<Boolean> removeShop(Long id) {

        shopMapper.deleteByPrimaryKey(id);

        shopExtParamMapper.deleteByShopId(id);

        return BaseResponse.defaultBuildSuccess(true);
    }
}
