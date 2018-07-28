package com.alibaba.middleware.diamond;

import org.springframework.stereotype.Service;

/**
 * 演示在Listener里把配置注入到这个bean里，注意是非线程安全
 *
 * @author chengxu
 */
@Service
public class ConfigBean {

    private String id;
    private int number;

    private Foo foo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "ConfigBean [id=" + id + ", number=" + number + ", foo=" + foo + "]";
    }

}
