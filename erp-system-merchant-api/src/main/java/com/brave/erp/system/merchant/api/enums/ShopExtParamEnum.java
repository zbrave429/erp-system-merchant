package com.brave.erp.system.merchant.api.enums;

/**
 * 门店扩展数据枚举
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 21:02
 */
public class ShopExtParamEnum {
    ;

    private final String code;

    private final String desc;

    ShopExtParamEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
