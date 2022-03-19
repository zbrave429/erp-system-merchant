package com.brave.erp.system.merchant.api.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:26
 */
@Data
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -2886301656688984065L;

    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 门店ID
     */
    private Long shopId;

    /**
     * 手机号码
     */
    private String mobileNo;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 状态
     */
    private Integer status;

    private String addBy;

    private Date addTime;

    private String updateBy;

    private Date updateTime;

    private Boolean isDelete;
}
