package com.brave.erp.system.merchant.api.request;

import com.brave.erp.system.merchant.api.dto.OrderByField;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import lombok.Data;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.io.Serializable;
import java.util.List;

/**
 * 分页门店信息查询请求
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 08:53
 */
@Data
public class ShopQueryPageRequest implements Serializable {

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
    private Page page;

    /**
     * 查询数据集（返回结果数据）
     */
    @RequestParam("查询数据集（返回结果数据）")
    private List<ShopDataFieldEnum> shopDataFields;

    /**
     * 查询排序字段
     */
    @RequestParam("查询排序字段")
    private List<OrderByField> orderByFields;

}
