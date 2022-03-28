package com.brave.erp.system.merchant.api.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.io.Serializable;

/**
 * 分页门店信息查询请求
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 08:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShopQueryPageRequest extends ShopQueryListRequest implements Serializable {

    private static final long serialVersionUID = -5210458189513356955L;

    /**
     * 商户ID
     */
    @RequestParam("商户ID")
    private Long merchantId;

    /**
     * 分页参数
     */
    @RequestParam("分页参数")
    private Page pager;

}
