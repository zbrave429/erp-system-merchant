package com.brave.erp.system.merchant.api.dto;

import lombok.Data;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 门店服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:22
 */
@Data
public class ShopDto implements Serializable {

    private static final long serialVersionUID = 6499269203259998894L;

    @ResponseProperty("门店ID")
    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 门店类型
     */
    private Integer shopType;

    /**
     * logo图名字
     */
    private String logo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否主账号
     */
    private Boolean isMaster;

    /**
     * 地址
     */
    private String address;

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
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;
}
