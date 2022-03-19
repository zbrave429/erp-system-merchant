package com.brave.erp.system.merchant.service.context.adaptor;

/**
 * 适配器基础接口定义
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-19 10:17
 */
public interface BaseAdaptor {

    /**
     * 判断是否执行当前适配器的方法
     * @return true-执行
     */
    boolean able();

    /**
     * 准备数据，多表数据查询，可以在此方法开启异步查询任务
     */
    void pre();

    /**
     * 获取任务处理结果，执行后续逻辑
     * @throws Exception 执行一次
     */
    void exe() throws Exception;

}
