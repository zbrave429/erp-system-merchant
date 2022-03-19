package com.brave.erp.system.merchant.service.mapper;

import com.brave.erp.system.merchant.service.domain.Shop;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:17
 */
@Mapper
public interface ShopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}