package com.brave.erp.system.merchant.api.dto;

import lombok.Data;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商户数据模型
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 20:30
 */
@Data
public class MerchantModelDto implements Serializable {

    private static final long serialVersionUID = -9145391019374080439L;

    @ResponseProperty("商户ID")
    private Long merchantId;

    @ResponseProperty("商户基础信息")
    private MerchantDto merchantDto;

    @ResponseProperty("商户下的门店列表")
    private List<ShopModelDto> shopModelDtos;

    @ResponseProperty("商户扩展数据")
    private Map<String, String> extParam;

}
