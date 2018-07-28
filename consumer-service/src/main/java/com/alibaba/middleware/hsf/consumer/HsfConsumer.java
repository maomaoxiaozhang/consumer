package com.alibaba.middleware.hsf.consumer;

import com.alibaba.middleware.hsf.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HsfConsumer {
    @Autowired
    public HelloService service;
}
