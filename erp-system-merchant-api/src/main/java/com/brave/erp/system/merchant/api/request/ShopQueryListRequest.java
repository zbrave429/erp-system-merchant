package com.brave.erp.system.merchant.api.request;

import com.brave.erp.system.merchant.api.dto.OrderByField;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import lombok.Data;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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
    @NotNull
    @Size(min = 1, max = 100, message = "门店ID列表不能为空，且最多不超过100个")
    private List<Long> shopIds;

    @RequestParam("查询数据集（返回结果数据）")
    @NotEmpty
    private List<ShopDataFieldEnum> shopDataFields;

    /**
     * 查询排序字段
     */
    @RequestParam("查询排序字段")
    private List<OrderByField> orderByFields;

}
