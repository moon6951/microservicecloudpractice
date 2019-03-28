package com.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component // 不要忘记添加，不要忘记添加
public class TestServiceFallbackFactory implements FallbackFactory<TestService> {

    @Override
    public TestService create(Throwable throwable) {
        return new TestService() {
            @Override
            public String get() {
                return "暂停服务";
            }
        };
    }
};


