package com.brave.erp.system.merchant.service.mapper;

import com.brave.erp.system.merchant.service.domain.Merchant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:10
 */
@Mapper
public interface MerchantMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Long id);

    List<Merchant> selectListByIds(List<Long> ids);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}