package com.brave.erp.system.merchant.api.request;

import com.brave.erp.system.merchant.api.enums.MerchantDataFieldEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商户信息查询，根据商户ID查询单条商户信息
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 21:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantQueryRequest implements Serializable {

    private static final long serialVersionUID = 4456990694565713886L;

    @RequestParam(value = "商户ID", required = true)
    private Long merchantId;

    @RequestParam(value = "查询数据集", required = true)
    private List<MerchantDataFieldEnum> dataFieldEnums;

    public static MerchantQueryRequest buildDefaultRequest(Long merchantId){
        return new MerchantQueryRequest(merchantId,
                Arrays.stream(MerchantDataFieldEnum.values())
                        .collect(Collectors.toList()));
    }

}
