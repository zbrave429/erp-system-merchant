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

    int deleteByMerchantId(Long merchantId);

    int batchDeleteByExtCodes(@Param("merchantId") Long merchantId,
                              @Param("extCodes") List<String> extCodes);

    int insert(MerchantExtParam record);

    int insertSelective(MerchantExtParam record);

    /**
     * 批量插入
     * @param records
     * @return
     */
    int batchInsert(List<MerchantExtParam> records);

    MerchantExtParam selectByPrimaryKey(Long id);

    List<MerchantExtParam> selectByMerchantId(Long merchantId);

    List<MerchantExtParam> selectByMerchantIds(@Param("merchantIds") List<Long> merchantIds);

    int updateByPrimaryKeySelective(MerchantExtParam record);

    int updateByPrimaryKey(MerchantExtParam record);
}