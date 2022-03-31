package com.brave.erp.system.merchant.api.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 创建商户
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-30 20:02
 */
@Data
public class CreateMerchantRequest implements Serializable {

    private static final long serialVersionUID = -2962228020358340592L;
    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 地址
     */
    private String address;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 商户分类
     * @see com.brave.erp.system.merchant.api.enums.MerchantTypeEnum
     */
    private Integer merchantType;

    /**
     * 状态
     * @see com.brave.erp.system.merchant.api.enums.MerchantStatusEnum
     */
    private Integer status;

    /**
     * 注册渠道
     * @see com.brave.erp.system.merchant.api.enums.RegisterChannelEnum
     */
    private Integer registerChannel;

    /**
     * 主账号ID
     */
    private Long masterUserId;

    /**
     * logo图片名
     */
    private String logo;

    /**
     * 操作人
     */
    private String addBy;

    /**
     * 扩展参数
     * @see com.brave.erp.system.merchant.api.enums.MerchantExtParamEnum
     */
    private Map<String, String> extParam;

}
