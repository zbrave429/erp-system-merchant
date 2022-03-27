package com.brave.erp.system.merchant.api.dto;

import lombok.Data;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 商户信息
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:14
 */
@Data
public class MerchantDto implements Serializable {

    private static final long serialVersionUID = -7031894116997993499L;
    /**
     * ID
     */
    @ResponseProperty(value = "商户ID")
    private Long id;

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
     */
    private Integer merchantType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 注册渠道
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

    private String addBy;

    private Date addTime;

    private String updateBy;

    private Date updateTime;

    /**
     * 描述
     */
    private String desc;

    private Boolean isDelete;
    /**
     * 扩展数据
     */
    private Map<String, String> extParam;
}
