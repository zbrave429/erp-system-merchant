package com.brave.erp.system.merchant.service.context;

import com.brave.erp.system.merchant.api.dto.ShopDto;
import com.brave.erp.system.merchant.api.dto.ShopModelDto;
import com.brave.erp.system.merchant.api.request.ShopQueryRequest;
import com.brave.erp.system.merchant.service.domain.Shop;
import com.brave.erp.system.merchant.service.domain.ShopExtParam;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * 门店信息查询上下文
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 08:58
 */
@Data
public class QueryShopListContext extends AbstractContext{

    private ShopQueryRequest request;

    private FutureTask<Shop> shopFuture;

    private Shop shop;

    FutureTask<List<ShopExtParam>> shopExtParamFuture;

    List<ShopExtParam> shopExtParams;

    private ShopModelDto result;

    public QueryShopListContext() {}

    public QueryShopListContext(ShopQueryRequest request) {
        this.request = request;
    }

    public static QueryShopListContext init(ShopQueryRequest request){
        return new QueryShopListContext(request);
    }

    public ShopModelDto build(){
        this.result = new ShopModelDto();

        buildShopBasic();
        buildShopExtParam();

        return this.result;
    }

    private void buildShopBasic(){
        if (Objects.isNull(shop)){
            return;
        }
        ShopDto shopDto = new ShopDto();
        BeanUtils.copyProperties(this.shop, shopDto);

        result.setShopDto(shopDto);
    }

    private void buildShopExtParam(){

        if (CollectionUtils.isEmpty(shopExtParams)){
            return;
        }
        result.setExtParam(shopExtParams.stream().collect(
                Collectors.toMap(ShopExtParam::getExtCode, ShopExtParam::getExtValue)));
    }
}
