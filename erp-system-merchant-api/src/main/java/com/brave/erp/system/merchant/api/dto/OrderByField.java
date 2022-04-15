package com.brave.erp.system.merchant.api.dto;

import com.brave.erp.system.merchant.api.enums.OrderByTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 排序字段
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-15 11:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderByField {

    /**
     * 排序字段
     */
    private String fieldName;

    /**
     * 排序方式
     * @see OrderByTypeEnum
     */
    private OrderByTypeEnum orderByType;

    public static OrderByField desc(String fieldName){
        return new OrderByField(fieldName, OrderByTypeEnum.DESC);
    }

    public static OrderByField asc(String fieldName){
        return new OrderByField(fieldName, OrderByTypeEnum.ASC);
    }

}
