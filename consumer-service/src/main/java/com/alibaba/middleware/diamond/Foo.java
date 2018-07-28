package com.alibaba.middleware.diamond;

/**
 * @author chengxu
 */
public class Foo {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    String name;

    @Override
    public String toString() {
        return "Foo [name=" + name + ", active=" + active + "]";
    }

    boolean active;
}
