package com.brave.erp.system.merchant.api.request;

import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import lombok.Data;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.util.List;

/**
 * 门店信息查询请求
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 08:53
 */
@Data
public class ShopQueryRequest {

    @RequestParam("门店Id")
    private Long shopId;

    @RequestParam("查询数据集")
    private List<ShopDataFieldEnum> shopDataFields;

}
