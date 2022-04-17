package com.brave.erp.system.merchant.api.request;

import lombok.Data;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * 更新门店请求入参
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 20:56
 */
@Data
public class UpdateShopRequest implements Serializable {

    private static final long serialVersionUID = -6017510520768556592L;

    @ResponseProperty("门店ID")
    private Long id;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 门店类型
     */
    private Integer shopType;

    /**
     * logo图名字
     */
    private String logo;

    /**
     * 是否主账号
     */
    private Boolean isMaster;

    /**
     * 地址
     */
    private String address;

    /**
     * 描述
     */
    private String desc;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    private Map<String, String> extParam;
}
