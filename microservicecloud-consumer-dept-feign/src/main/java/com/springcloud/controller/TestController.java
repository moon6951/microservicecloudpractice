package com.springcloud.controller;

import com.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
	@Autowired
	RestTemplate restTemplate;


	@Autowired
	private TestService service;
	@GetMapping("/consumer/test")
	public String test(){
		return this.service.get();
		//return this.restTemplate.getForObject("http://localhost:8001/get", String.class);
	}
	@GetMapping("/consumer/getting/{a}")
	public String getting(@PathVariable("a") int a){
		String url = "http://MICROSERVICEPROVIDER8001";
		return this.restTemplate.getForObject(url+"/getting"+a, String.class);
	}
}
