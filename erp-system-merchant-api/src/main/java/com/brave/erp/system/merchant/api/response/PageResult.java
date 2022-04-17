package com.brave.erp.system.merchant.api.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-28 22:42
 */
@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 8076668154712114910L;

    /**
     * 本次查询返回记录
     */
    private List<T> records;

    /**
     * 总记录数
     */
    private long total;

}
