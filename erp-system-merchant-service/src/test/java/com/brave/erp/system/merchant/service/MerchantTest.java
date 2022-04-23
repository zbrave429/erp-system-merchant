package com.brave.erp.system.merchant.service;

import com.brave.erp.system.merchant.api.dto.MerchantModelDto;
import com.brave.erp.system.merchant.api.enums.ErrCodeEnum;
import com.brave.erp.system.merchant.api.enums.MerchantExtParamEnum;
import com.brave.erp.system.merchant.api.request.CreateMerchantRequest;
import com.brave.erp.system.merchant.api.request.MerchantQueryRequest;
import com.brave.erp.system.merchant.api.request.UpdateMerchantRequest;
import com.brave.erp.system.merchant.api.response.BaseResponse;
import com.brave.erp.system.merchant.api.service.MerchantQueryService;
import com.brave.erp.system.merchant.api.service.MerchantService;

import com.google.common.collect.Maps;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * 门店查询单测
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-18 22:37
 */
public class MerchantTest extends BaseTest{

    @Autowired
    private MerchantService merchantService;

//    @DubboReference(url = "dubbo://localhost:20883", version = "1.0.1")
//    private MerchantService merchantService;

//    @Autowired
//    private MerchantQueryService merchantQueryService;

    /**
     * 可用于本地测试，通过dubbo调用接口
     * 参考文档：https://dubbo.apache.org/zh/docs/advanced/explicit-target/
//     */
    @DubboReference( version = "1.0.1")
    private MerchantQueryService merchantQueryService;

    @Test
    public void curdTest(){
        // 新增
        long id = createMerchant();
        // 更新
        updateMerchant(id);
        // 删除
        removeMerchant(id);
    }


    @Test
    public long createMerchant() {

        CreateMerchantRequest request = new CreateMerchantRequest();
        request.setMerchantName("自动化测试商户_" + System.currentTimeMillis());
        request.setMerchantType(1);
        request.setAddress("上海市长宁区XXX小区XXX室");
        request.setLat("31.23232");
        request.setLng("120.23231");
        request.setLogo("test.png");
        request.setStatus(0);
        request.setRegisterChannel(0);
        request.setMasterUserId(1L);
        request.setAddBy("brave");

        Map<String, String> extParams = Maps.newHashMap();
        extParams.put(MerchantExtParamEnum.TEST.getCode(), "测试扩展数据");
        extParams.put(MerchantExtParamEnum.TEST2.getCode(), "测试扩展数据2");
        request.setExtParam(extParams);

        BaseResponse<Long> response = merchantService.createMerchant(request);
        System.out.println(response);
        return response.getResult();
    }

    @Test
    public void updateMerchant(Long id) {

        BaseResponse<MerchantModelDto> response = merchantQueryService.queryById(MerchantQueryRequest.buildDefaultRequest(id));

        System.out.println(response);

        UpdateMerchantRequest request = new UpdateMerchantRequest();

        BeanUtils.copyProperties(response.getResult().getMerchantDto(), request);
        request.setExtParam(response.getResult().getExtParam());

        String merchantName = "自动化测试商户_" + System.currentTimeMillis();

        request.setMerchantName(merchantName);

        BaseResponse<Boolean> updateMerchantRes = merchantService.updateMerchant(request);

        Assert.isTrue(updateMerchantRes.isSuccess() && updateMerchantRes.getResult(),"更新失败");

        BaseResponse<MerchantModelDto> afterResponse = merchantQueryService.queryById(MerchantQueryRequest.buildDefaultRequest(id));

        System.out.println(afterResponse);

        Assert.isTrue(merchantName.equals(afterResponse.getResult().getMerchantDto().getMerchantName()), "更新失败");

    }

    @Test
    public void removeMerchant(Long id) {

        BaseResponse<MerchantModelDto> before = merchantQueryService.queryById(MerchantQueryRequest.buildDefaultRequest(id));

        Assert.isTrue(before.isSuccess(), "订单查询失败");

        BaseResponse<Boolean> removeMerchant = merchantService.removeMerchant(id);

        Assert.isTrue(removeMerchant.isSuccess() && removeMerchant.getResult(), "商户删除接口返回失败");

        BaseResponse<MerchantModelDto> response = merchantQueryService.queryById(MerchantQueryRequest.buildDefaultRequest(id));

        Assert.isTrue(!response.isSuccess()
                && response.getCode() == ErrCodeEnum.DATA_NO_EXIST.getCode(), "删除失败");

    }

    @Test
    public void queryMerchant(){

        MerchantQueryRequest request = MerchantQueryRequest.buildDefaultRequest(null);

        BaseResponse<MerchantModelDto> response = merchantQueryService.queryById(request);

        System.out.println(response);

    }
}
