package com.brave.erp.system.merchant.service.util;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.brave.erp.system.merchant.api.dto.OrderByField;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序查询工具
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 13:14
 */
public class OrderByUtil {

    public static void orderBy(List<OrderByField> orderByFields){
        if(CollectionUtils.isNotEmpty(orderByFields)){
            String orderByStr = orderByFields.stream()
                    .distinct()
                    .map(orderByField -> orderByField.getFieldName() + " " + orderByField.getOrderByType().name())
                    .collect(Collectors.joining(","));
            PageHelper.orderBy(orderByStr);
        }
    }

    /**
     * 排序
     * @param orderByFields 排序规则
     * @param defaultFields 默认排序规则
     */
    public static void orderBy(List<OrderByField> orderByFields, List<OrderByField> defaultFields){

        if(CollectionUtils.isNotEmpty(orderByFields)){
            orderBy(orderByFields);
        } else {
            orderBy(defaultFields);
        }
    }
}
