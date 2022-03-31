package com.brave.erp.system.merchant.api.enums;

/**
 * 商户扩展参数
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-31 21:56
 */
public enum MerchantExtParamEnum {
    TEST("10001", "测试参数"),
    TEST2("10002", "测试参数2"),
    ;

    private final String code;

    private final String desc;

    MerchantExtParamEnum(String code, String desc) {
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
