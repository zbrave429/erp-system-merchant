package com.brave.erp.system.merchant.api.enums;

/**
 * 错误码
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-12 09:55
 */
public enum ErrCodeEnum {
    SUCCESS(200, "成功"),
    PARAMS_MISS_ERROR(101, "参数缺失"),
    PARAMS_NAME_REPEAT(102, "类目名称[%s]已存在，请重新输入！"),
    PARAMS_PARENT_NO_EXIST(103, "父级类别不存在，请重试！"),
    PARAMS_DATA_NO_EXIST(104, "操作记录不存在，请刷新后重试！"),
    DATA_NO_EXIST(404, "数据不存在！"),
    SYSTEM_BUSY_ERROR(998, "系统繁忙，请稍后重试！"),
    SYSTEM_ERROR(999, "系统异常，请稍后重试！"),
    ;

    private final int code;

    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ErrCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
