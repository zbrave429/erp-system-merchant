package com.brave.erp.system.merchant.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.dubbo.apidocs.annotations.RequestParam;

import java.io.Serializable;

/**
 * 分页参数
 *
 * @author <a href='1286998496@qq.com'>zhangyong</a>
 * @date 2022-03-28 22:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Page implements Serializable {

    private static final long serialVersionUID = 8819447843592168785L;
    /**
     * 页码
     */
    @RequestParam("页码")
    private int page;

    /**
     * 每页数量
     */
    @RequestParam("每页数量")
    private int size;

}
