package com.brave.erp.system.merchant.api.dto;

import lombok.Data;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * 用户数据模型
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 20:35
 */
@Data
public class UserModelDto implements Serializable {

    private static final long serialVersionUID = -1034909505439338334L;

    @ResponseProperty("用户ID")
    private Long userId;

    @ResponseProperty("用户基础信息")
    private UserDto userDto;

    @ResponseProperty("用户扩展信息")
    private Map<String, String> extParam;

    @ResponseProperty("用户所在商户信息")
    private MerchantDto merchantDto;

    @ResponseProperty("用户所在门店信息")
    private ShopDto shopDto;

}
