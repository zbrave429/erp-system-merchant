package com.brave.erp.system.merchant.service.context.handle;

import com.brave.erp.system.merchant.service.context.QueryShopContext;
import com.brave.erp.system.merchant.service.context.adaptor.AbstractBaseAdaptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 适配器
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 12:26
 */
@Slf4j
@Component
public class QueryShopAdaptorHandler{

    // 通过spring注入泛型为QueryShopContext的适配器列表
    private final List<AbstractBaseAdaptor<QueryShopContext>> queryShopAdaptors;

    public QueryShopAdaptorHandler(List<AbstractBaseAdaptor<QueryShopContext>> queryShopAdaptors) {
        this.queryShopAdaptors = queryShopAdaptors;
    }


    public void queryShopById(QueryShopContext context) throws Exception {
        try {
            // 设置线程上下文信息
            AbstractBaseAdaptor.set(context);
            // 查询数据
            queryShopAdaptors.forEach(AbstractBaseAdaptor::prepare);

            // 数据处理
            for (AbstractBaseAdaptor<QueryShopContext> adaptor : queryShopAdaptors) {
                adaptor.execute();
            }
        } catch (Exception e) {
            log.error("QueryShopAdaptorHandler queryShopById error! context={}", context, e);
            throw e;
        } finally {
            // 清除上下文
            AbstractBaseAdaptor.remove();
        }
    }

}
