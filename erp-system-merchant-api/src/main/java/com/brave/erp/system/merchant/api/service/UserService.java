package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.dto.UserDto;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import org.apache.dubbo.apidocs.annotations.ApiDoc;
import org.apache.dubbo.apidocs.annotations.ApiModule;

import java.util.List;

/**
 * 用户数据维护服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:21
 */
@ApiModule(value = "用户数据维护服务", apiInterface = UserService.class)
public interface UserService {

    @ApiDoc(value = "创建用户")
    BaseResponse<Long> createUser();

    @ApiDoc(value = "更新用户信息")
    BaseResponse<Long> updateUser();

    @ApiDoc(value = "删除用户信息")
    BaseResponse<Boolean> removeUser();

}
