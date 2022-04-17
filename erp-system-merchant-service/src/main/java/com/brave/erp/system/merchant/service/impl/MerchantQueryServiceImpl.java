package com.brave.erp.system.merchant.service.impl;

import com.brave.dubbo.trace.thread.AsyncTaskFactory;
import com.brave.erp.system.merchant.api.dto.MerchantDto;
import com.brave.erp.system.merchant.api.dto.MerchantModelDto;
import com.brave.erp.system.merchant.api.enums.ErrCodeEnum;
import com.brave.erp.system.merchant.api.request.MerchantQueryRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.response.PageResult;
import com.brave.erp.system.merchant.api.service.MerchantQueryService;
import com.brave.erp.system.merchant.service.annotation.WriteLog;
import com.brave.erp.system.merchant.service.domain.Merchant;
import com.brave.erp.system.merchant.service.domain.MerchantExtParam;
import com.brave.erp.system.merchant.service.mapper.MerchantExtParamMapper;
import com.brave.erp.system.merchant.service.mapper.MerchantMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * 用户服务实现
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:28
 */
@Slf4j
@DubboService
@Service
public class MerchantQueryServiceImpl implements MerchantQueryService {

    private final MerchantMapper merchantMapper;

    private final MerchantExtParamMapper merchantExtParamMapper;

    public MerchantQueryServiceImpl(MerchantMapper merchantMapper,
                                    MerchantExtParamMapper merchantExtParamMapper) {
        this.merchantMapper = merchantMapper;
        this.merchantExtParamMapper = merchantExtParamMapper;
    }

    @Override
    @WriteLog("queryMerchantDtoById")
    public BaseResponse<MerchantModelDto> queryById(MerchantQueryRequest request) {

        try {
            FutureTask<Merchant> merchantFuture = AsyncTaskFactory.submit(() -> merchantMapper.selectByPrimaryKey(request.getMerchantId()));
            FutureTask<List<MerchantExtParam>> merchantExtFuture = AsyncTaskFactory.submit(() -> merchantExtParamMapper.selectByMerchantId(request.getMerchantId()));

            Merchant merchant = merchantFuture.get();
            List<MerchantExtParam> merchantExtParams = merchantExtFuture.get();

            MerchantModelDto merchantModelDto = new MerchantModelDto();

            MerchantDto merchantDto = new MerchantDto();
            if (Objects.isNull(merchant)){
                return BaseResponse.buildError(ErrCodeEnum.DATA_NO_EXIST);
            }
            BeanUtils.copyProperties(merchant, merchantDto);
            merchantModelDto.setMerchantId(request.getMerchantId());
            merchantModelDto.setMerchantDto(merchantDto);

            if(!CollectionUtils.isEmpty(merchantExtParams)){
                merchantModelDto.setExtParam(merchantExtParams.stream().collect(
                        Collectors.toMap(MerchantExtParam::getExtCode, MerchantExtParam::getExtValue)));
            }

            return BaseResponse.defaultBuildSuccess(merchantModelDto);
        } catch (Exception e) {
            log.error("MerchantServiceImpl queryById error,id={}", request.getMerchantId(), e);
            return BaseResponse.buildError(ErrCodeEnum.SYSTEM_ERROR);
        }
    }

    @Override
    @WriteLog("queryMerchantDtoListByIds")
    public BaseResponse<List<MerchantModelDto>> queryListByIds(List<Long> ids) {

        try {
            FutureTask<List<Merchant>> merchantsFuture = AsyncTaskFactory.submit(() -> merchantMapper.selectListByIds(ids));
            FutureTask<List<MerchantExtParam>> merchantExtFuture = AsyncTaskFactory.submit(() -> merchantExtParamMapper.selectByMerchantIds(ids));

            List<Merchant> merchants = merchantsFuture.get();
            List<MerchantExtParam> merchantExtParams = merchantExtFuture.get();
            Map<Long, List<MerchantExtParam>> extGroupById = groupByMerchantId(merchantExtParams);

            List<MerchantModelDto> res = Lists.newArrayList();

            merchants.forEach(merchant -> {
                MerchantModelDto merchantModelDto = new MerchantModelDto();
                MerchantDto merchantDto = new MerchantDto();
                BeanUtils.copyProperties(merchant, merchantDto);
                merchantModelDto.setMerchantId(merchant.getId());
                merchantModelDto.setMerchantDto(merchantDto);
                if(extGroupById.containsKey(merchant.getId())){
                    merchantModelDto.setExtParam(extGroupById.get(merchant.getId()).stream().collect(
                            Collectors.toMap(MerchantExtParam::getExtCode, MerchantExtParam::getExtValue)));
                }
                res.add(merchantModelDto);
            });

            return BaseResponse.defaultBuildSuccess(res);
        } catch (Exception e) {
            log.error("MerchantServiceImpl queryListByIds error,ids={}", ids, e);
            return BaseResponse.buildError(ErrCodeEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public BaseResponse<PageResult<MerchantModelDto>> queryByPage(List<Long> ids) {
        return null;
    }

    private Map<Long, List<MerchantExtParam>> groupByMerchantId(List<MerchantExtParam> merchantExtParams){
        Map<Long, List<MerchantExtParam>> res = new HashMap<>();

        for (MerchantExtParam item: merchantExtParams){
            if(res.containsKey(item.getMerchantId())){
                res.get(item.getMerchantId()).add(item);
            } else {
                res.put(item.getMerchantId(), Lists.newArrayList(item));
            }
        }
        return res;
    }

}

