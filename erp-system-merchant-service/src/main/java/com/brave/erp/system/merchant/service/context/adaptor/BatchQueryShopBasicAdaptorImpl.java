package com.brave.erp.system.merchant.service.context.adaptor;

import com.brave.erp.system.merchant.service.context.BatchQueryShopContext;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 10:09
 */
@Component
public class BatchQueryShopBasicAdaptorImpl extends AbstractBaseAdaptor<BatchQueryShopContext> {

    @Override
    public boolean able() {
        return false;
    }

    @Override
    public void pre() {
    }

    @Override
    public void exe() throws Exception {
    }

}
