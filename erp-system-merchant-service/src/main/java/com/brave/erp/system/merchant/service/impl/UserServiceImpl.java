package com.brave.erp.system.merchant.service.impl;

import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 21:25
 */
@Slf4j
@DubboService
@Service
public class UserServiceImpl implements UserService {

    @Override
    public BaseResponse<Long> createUser() {
        return null;
    }

    @Override
    public BaseResponse<Long> updateUser() {
        return null;
    }

    @Override
    public BaseResponse<Boolean> removeUser() {
        return null;
    }
}
