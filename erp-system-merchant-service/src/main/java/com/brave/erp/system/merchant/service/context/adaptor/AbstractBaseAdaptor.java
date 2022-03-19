package com.brave.erp.system.merchant.service.context.adaptor;

import com.brave.erp.system.merchant.service.context.AbstractContext;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 10:07
 */
public abstract class AbstractBaseAdaptor<T extends AbstractContext> implements BaseAdaptor {

    private static final ThreadLocal<AbstractContext> CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    public void prepare(){
        if (able()){
            pre();
        }
    }

    public void execute() throws Exception {
        if(able()){
            exe();
        }
    }

    public static void set(AbstractContext t){
        CONTEXT_THREAD_LOCAL.set(t);
    }

    public T get(){
        return (T) CONTEXT_THREAD_LOCAL.get();
    }

    public static void remove(){
        CONTEXT_THREAD_LOCAL.remove();
    }

}
