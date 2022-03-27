package com.brave.erp.system.merchant.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 门店数据模型
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 09:03
 */
@Data
public class ShopModelDto implements Serializable {
    private static final long serialVersionUID = -9218898348847532598L;

    /**
     * 门店基础信息
     */
    private ShopDto shopDto;

    /**
     * 门店扩展参数
     */
    private Map<String, String> extParam;

}
