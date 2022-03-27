package com.brave.erp.system.merchant.api.response;

import com.brave.erp.system.merchant.api.enums.ErrCodeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.dubbo.apidocs.annotations.ResponseProperty;

import java.io.Serializable;

/**
 * 响应
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-12 09:52
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -3474080406481968444L;

    /**
     * 响应码， 200-成功，其他失败
     * @see ErrCodeEnum 枚举值
     */
    @ResponseProperty(value = "响应码", example = "")
    private int code;

    @ResponseProperty(value = "响应描述")
    private String message;

    @ResponseProperty(value = "响应数据")
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess(){
        return ErrCodeEnum.SUCCESS.getCode() == code;
    }

    public BaseResponse() {}

    private BaseResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    private BaseResponse(ErrCodeEnum errCodeEnum, T result) {
        this.code = errCodeEnum.getCode();
        this.message = errCodeEnum.getDesc();
        this.result = result;
    }

    private BaseResponse(ErrCodeEnum errCodeEnum) {
        this.code = errCodeEnum.getCode();
        this.message = errCodeEnum.getDesc();
    }

    private BaseResponse(ErrCodeEnum errCodeEnum, Object... names) {
        this.code = errCodeEnum.getCode();
        this.message = String.format(errCodeEnum.getDesc(), names);
    }

    public static <T> BaseResponse<T> buildError(ErrCodeEnum errCodeEnum){
        return new BaseResponse<>(errCodeEnum);
    }

    public static <T> BaseResponse<T> buildError(ErrCodeEnum errCodeEnum, Object... names){
        return new BaseResponse<>(errCodeEnum, names);
    }

    public static <T> BaseResponse<T> defaultBuildSuccess(T result){
        return new BaseResponse<>(ErrCodeEnum.SUCCESS, result);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
