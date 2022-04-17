package com.brave.erp.system.merchant.service.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 门店扩展信息
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:11
 */
@Data
@NoArgsConstructor
public class ShopExtParam {
    private Long id;

    private Long shopId;

    private String extCode;

    private String extValue;

    private String addBy;

    private Date addTime;

    private String updateBy;

    private Date updateTime;

    public ShopExtParam(Long shopId, String extCode, String extValue) {
        this.shopId = shopId;
        this.extCode = extCode;
        this.extValue = extValue;
    }
}