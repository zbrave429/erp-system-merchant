package com.brave.erp.system.merchant.service.helper;

import com.brave.erp.system.merchant.api.request.ShopQueryPageRequest;
import com.brave.erp.system.merchant.service.domain.query.ShopQueryParam;
import org.springframework.stereotype.Component;

/**
 * 门店查询辅助类
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-04-17 15:26
 */
@Component
public class ShopQueryHelper {

    public static ShopQueryParam buildShopQueryParam(ShopQueryPageRequest request){
        ShopQueryParam shopQueryParam = new ShopQueryParam();
        shopQueryParam.setMerchantId(request.getMerchantId());
        return shopQueryParam;
    }



}
