package com.brave.erp.system.merchant.service.impl;

import com.brave.erp.system.merchant.api.dto.MerchantDto;
import com.brave.erp.system.merchant.api.request.CreateMerchantRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.MerchantService;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import com.brave.erp.system.merchant.service.domain.Merchant;
import com.brave.erp.system.merchant.service.domain.MerchantExtParam;
import com.brave.erp.system.merchant.service.mapper.MerchantExtParamMapper;
import com.brave.erp.system.merchant.service.mapper.MerchantMapper;
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
    public BaseResponse<MerchantDto> updateMerchant(CreateMerchantRequest request) {
        return null;
    }

    @Override
    public BaseResponse<Boolean> removeMerchant(Long id) {
        return null;
    }


    private Merchant buildMerchant(CreateMerchantRequest request){
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(request, merchant);
        return merchant;
    }

}
