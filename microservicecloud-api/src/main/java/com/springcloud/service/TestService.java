package com.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "MICROSERVICEPROVIDER8001",fallbackFactory=TestServiceFallbackFactory.class)
public interface TestService {
    @RequestMapping(value="/get",method = RequestMethod.GET)
    public String get();
}
