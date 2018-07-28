package com.alibaba.middleware.diamond;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Diamond的例子，通过@Value将Diamond的配置注入到对象中
 * 详见http://gitlab.alibaba-inc.com/middleware-container/pandora-boot/wikis/spring-boot-diamond
 *
 * @author chengxu
 */
@Component
public class DiamondDemo {

    /**
     * 这里null的数据，是通过application.properties配置注入的
     */
    @Value("${string}")
    private String stringValue;

    @Override
    public String toString() {
        return "DiamondDemo{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", booleanValue=" + booleanValue +
                '}';
    }

    @Value("${number}")
    private int intValue;

    @Value("${boolean}")
    private boolean booleanValue;

    public String getStringValue() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }
}
