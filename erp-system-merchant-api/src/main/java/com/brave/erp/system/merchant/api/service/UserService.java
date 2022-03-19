package com.brave.erp.system.merchant.api.service;

import com.brave.erp.system.merchant.api.dto.UserDto;

import java.util.List;

/**
 * 用户服务
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:21
 */
public interface UserService {

    UserDto queryById(Long id);

    List<UserDto> queryListByIds(List<Long> ids);

}
