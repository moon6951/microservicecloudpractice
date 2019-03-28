package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.jackson.builder.StringInterningAmazonInfoBuilder;

@RestController
public class TestController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consumer/test")
	public String test(){
		String url = "http://MICROSERVICEPROVIDER8001";
		return this.restTemplate.getForObject(url+"/get", String.class);
		//return this.restTemplate.getForObject("http://localhost:8001/get", String.class);
	}
	@GetMapping("/consumer/getting/{a}")
	public String getting(@PathVariable("a") int a){
		String url = "http://MICROSERVICEPROVIDER8001";
		return this.restTemplate.getForObject(url+"/getting"+a, String.class);
	}
}
