package com.brave.erp.system.merchant.service.mapper;

import com.brave.erp.system.merchant.service.domain.MerchantExtParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-17 22:10
 */
@Mapper
public interface MerchantExtParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MerchantExtParam record);

    int insertSelective(MerchantExtParam record);

    MerchantExtParam selectByPrimaryKey(Long id);

    List<MerchantExtParam> selectByMerchantId(Long merchantId);

    List<MerchantExtParam> selectByMerchantIds(@Param("merchantIds") List<Long> merchantIds);

    int updateByPrimaryKeySelective(MerchantExtParam record);

    int updateByPrimaryKey(MerchantExtParam record);
}