package com.brave.erp.system.merchant.service.mapper;

import com.brave.erp.system.merchant.service.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:11
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}