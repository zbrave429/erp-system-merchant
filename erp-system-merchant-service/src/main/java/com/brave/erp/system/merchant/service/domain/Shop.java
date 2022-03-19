package com.brave.erp.system.merchant.service.domain;

import lombok.Data;

import java.util.Date;

/**
 * 门店基础信息
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:17
 */
@Data
public class Shop {
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