package com.brave.erp.system.merchant.service.domain.query;

import lombok.Data;

import java.util.Date;

/**
 * 门店查询参数模型
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 15:23
 */
@Data
public class ShopQueryParam {

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 门店名称
     */
    private String shopName;

}
