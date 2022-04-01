package com.brave.erp.system.merchant.service.impl;

import com.brave.erp.system.merchant.api.request.CreateMerchantRequest;
import com.brave.erp.system.merchant.api.request.UpdateMerchantRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.MerchantService;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import com.brave.erp.system.merchant.service.domain.Merchant;
import com.brave.erp.system.merchant.service.domain.MerchantExtParam;
import com.brave.erp.system.merchant.service.mapper.MerchantExtParamMapper;
import com.brave.erp.system.merchant.service.mapper.MerchantMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-31 22:02
 */
@Slf4j
@DubboService
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private MerchantExtParamMapper merchantExtParamMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @WriteLog("createMerchant")
    public BaseResponse<Long> createMerchant(CreateMerchantRequest request) {

        // todo 校验数据，后续通过框架统一进行参数校验
        Merchant merchant = buildMerchant(request);
        merchantMapper.insertSelective(merchant);

        if (!CollectionUtils.isEmpty(request.getExtParam())){
            List<MerchantExtParam> extParams = request.getExtParam().entrySet().stream()
                    .map(entry -> new MerchantExtParam(merchant.getId(), entry.getKey(), entry.getValue(), request.getAddBy()))
                    .collect(Collectors.toList());
            merchantExtParamMapper.batchInsert(extParams);
        }

        return BaseResponse.defaultBuildSuccess(merchant.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @WriteLog("updateMerchant")
    public BaseResponse<Boolean> updateMerchant(UpdateMerchantRequest request) {

        // todo 校验数据，后续通过框架统一进行参数校验

        Merchant merchant = buildMerchant(request);
        merchantMapper.updateByPrimaryKeySelective(merchant);

        if (!CollectionUtils.isEmpty(request.getExtParam())){
            List<String> extCodes = Lists.newArrayList(request.getExtParam().keySet());

            // delete
            merchantExtParamMapper.batchDeleteByExtCodes(merchant.getId(), extCodes);

            // batchInsert
            List<MerchantExtParam> extParams = request.getExtParam().entrySet().stream()
                    .map(entry -> new MerchantExtParam(merchant.getId(), entry.getKey(), entry.getValue(), request.getUpdateBy()))
                    .collect(Collectors.toList());
            merchantExtParamMapper.batchInsert(extParams);

        }
        return BaseResponse.defaultBuildSuccess(true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @WriteLog("removeMerchant")
    public BaseResponse<Boolean> removeMerchant(Long id) {

        // todo 校验数据，后续通过框架统一进行参数校验

        // 删除主表
        merchantMapper.deleteByPrimaryKey(id);

        // 删除子表
        merchantExtParamMapper.deleteByMerchantId(id);
        return BaseResponse.defaultBuildSuccess(true);
    }


    private Merchant buildMerchant(CreateMerchantRequest request){
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(request, merchant);
        return merchant;
    }

    private Merchant buildMerchant(UpdateMerchantRequest request){
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(request, merchant);
        return merchant;
    }

}
