package com.brave.erp.system.merchant.service.mapper;

import com.brave.erp.system.merchant.service.domain.ShopExtParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:11
 */
@Mapper
public interface ShopExtParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopExtParam record);

    int insertSelective(ShopExtParam record);

    ShopExtParam selectByPrimaryKey(Long id);

    List<ShopExtParam> selectListByShopId(Long shopId);

    int updateByPrimaryKeySelective(ShopExtParam record);

    int updateByPrimaryKey(ShopExtParam record);
}