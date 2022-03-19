package com.brave.erp.system.merchant.service.context.adaptor;

import cn.ygzhangmfh.util.task.AsyncFactory;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.service.context.QueryShopContext;
import com.brave.erp.system.merchant.service.domain.Shop;
import com.brave.erp.system.merchant.service.mapper.ShopMapper;
import org.springframework.stereotype.Component;

import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 10:09
 */
@Component
public class QueryShopBasicAdaptorImpl extends AbstractBaseAdaptor<QueryShopContext> {

    private final ShopMapper shopMapper;

    public QueryShopBasicAdaptorImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public boolean able() {
        QueryShopContext context = get();
        return context.getRequest().getShopDataFields().contains(ShopDataFieldEnum.BASIC);
    }

    @Override
    public void pre() {
        QueryShopContext context = get();
        FutureTask<Shop> shopFuture = AsyncFactory.submit(
                () -> shopMapper.selectByPrimaryKey(context.getRequest().getShopId()));
        context.setShopFuture(shopFuture);
    }

    @Override
    public void exe() throws Exception {
        QueryShopContext context = get();
        Shop shop = context.getShopFuture().get();
        context.setShop(shop);
    }

}
