package com.brave.erp.system.merchant.api.dto;

import lombok.Data;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 门店数据模型
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 09:03
 */
@Data
public class ShopListModelDto implements Serializable {

    private static final long serialVersionUID = -5924124090789433658L;

    /**
     * 门店列表
     */
    @ResponseProperty("门店列表")
    private List<ShopModelDto> shopModelDtos;

}
