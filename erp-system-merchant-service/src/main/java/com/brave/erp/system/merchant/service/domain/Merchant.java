package com.brave.erp.system.merchant.service.domain;

import lombok.Data;

import java.util.Date;

/**
 * 商户基础信息
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:10
 */
@Data
public class Merchant {
    /**
    * ID
    */
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
}