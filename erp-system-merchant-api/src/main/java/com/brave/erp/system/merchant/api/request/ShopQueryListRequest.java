package com.brave.erp.system.merchant.api.request;

import com.brave.erp.system.merchant.api.enums.OrderByTypeEnum;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.api.enums.ShopOrderByEnum;
import lombok.Data;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 门店信息查询请求
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 08:53
 */
@Data
public class ShopQueryListRequest implements Serializable {

    private static final long serialVersionUID = -5970991434935044155L;

    @RequestParam("门店Id")
    private List<Long> shopIds;

    @RequestParam("查询数据集（返回结果数据）")
    private List<ShopDataFieldEnum> shopDataFields;

    /**
     * key
     * @see ShopOrderByEnum
     *
     * value
     * @see OrderByTypeEnum
     */
    @RequestParam("查询排序字段")
    private Map<String, String> orderByFields;

}
