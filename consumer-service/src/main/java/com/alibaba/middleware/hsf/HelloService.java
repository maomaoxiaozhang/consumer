package com.alibaba.middleware.hsf;

/**
 * HSF服务接口
 *
 * @author chengxu
 */
public interface HelloService {

    /**
     * HSF服务的方法
     * @param name
     * @return 调用HSF服务返回的结果
     */
    String getSql(String name);
}
