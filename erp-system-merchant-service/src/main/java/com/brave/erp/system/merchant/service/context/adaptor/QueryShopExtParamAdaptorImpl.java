package com.brave.erp.system.merchant.service.context.adaptor;

import cn.ygzhangmfh.util.task.AsyncFactory;
import com.brave.erp.system.merchant.api.enums.ShopDataFieldEnum;
import com.brave.erp.system.merchant.service.context.QueryShopContext;
import com.brave.erp.system.merchant.service.domain.ShopExtParam;
import com.brave.erp.system.merchant.service.mapper.ShopExtParamMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 12:04
 */
@Component
public class QueryShopExtParamAdaptorImpl extends AbstractBaseAdaptor<QueryShopContext> {

    private final ShopExtParamMapper shopExtParamMapper;

    public QueryShopExtParamAdaptorImpl(ShopExtParamMapper shopExtParamMapper) {
        this.shopExtParamMapper = shopExtParamMapper;
    }

    @Override
    public boolean able() {
        QueryShopContext context = get();
        return context.getRequest().getShopDataFields().contains(ShopDataFieldEnum.EXT_PARAM);
    }

    @Override
    public void pre() {
        QueryShopContext context = get();
        FutureTask<List<ShopExtParam>> shopExtParamFuture = AsyncFactory.submit(
                () -> shopExtParamMapper.selectListByShopId(context.getRequest().getShopId()));

        context.setShopExtParamFuture(shopExtParamFuture);
    }

    @Override
    public void exe() throws Exception {
        QueryShopContext context = get();
        List<ShopExtParam> shopExtParams = context.getShopExtParamFuture().get();

        context.setShopExtParams(shopExtParams);
    }
}
