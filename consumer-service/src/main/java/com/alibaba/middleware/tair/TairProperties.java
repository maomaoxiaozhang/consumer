package com.alibaba.middleware.tair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.ResultCode;
import com.taobao.tair.TairManager;

/**
 * tair的例子，直接注入TairManager，通过它进行tair的put和get操作。详情见
 * http://gitlab.alibaba-inc.com/middleware-container/pandora-boot/wikis/spring-boot-tair
 *
 * @author chengxu
 */
@Component
public class TairProperties {

    private static final String SUCCESS = "success";

    @Autowired
    private TairManager tairManager;

    public boolean put(int nameSpace, String key, String value) {
        // tair的put操作，返回的ResultCode包括操作是否成功的信息
        ResultCode code = tairManager.put(nameSpace, key, value);
        return SUCCESS.equals(code.getMessage());
    }

    public String get(int nameSpace, String key) {
        Result<DataEntry> result = tairManager.get(nameSpace, key);
        return (String) result.getValue().getValue();
    }

    public boolean delete(int nameSpace, String key) {
        // tair的delete操作，返回的ResultCode包括操作是否成功的信息
        ResultCode code = tairManager.delete(nameSpace, key);
        if (SUCCESS.equals(code.getMessage())) {
            return true;
        } else {
            return false;
        }
    }
}