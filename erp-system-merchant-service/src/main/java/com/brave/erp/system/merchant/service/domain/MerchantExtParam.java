package com.brave.erp.system.merchant.service.domain;

import lombok.Data;

import java.util.Date;

/**
 * 商户扩展属性
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:10
 */
@Data
public class MerchantExtParam {
    private Long id;

    /**
    * 商户ID
    */
    private Long merchantId;

    /**
    * 扩展属性编码
    */
    private String extCode;

    /**
    * 扩展属性数据
    */
    private String extValue;

    private String addBy;

    private Date addTime;

    private String updateBy;

    private Date updateTime;
}