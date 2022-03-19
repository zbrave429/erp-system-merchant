package com.brave.erp.system.merchant.service.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:11
 */
@Data
public class User {
    private Long id;

    /**
    * 商户ID
    */
    private Long merchantId;

    /**
    * 门店ID
    */
    private Long shopId;

    /**
    * 手机号码
    */
    private String mobileNo;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 状态
    */
    private Integer status;

    private String addBy;

    private Date addTime;

    private String updateBy;

    private Date updateTime;

    private Boolean isDelete;
}