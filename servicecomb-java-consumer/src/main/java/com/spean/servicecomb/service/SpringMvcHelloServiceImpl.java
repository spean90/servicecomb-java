package com.spean.servicecomb.service;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.apache.servicecomb.tracing.Span;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spean.servicecomb.HelloService;

/** 
* @author siping_huang 
* @Date 2019年7月18日 下午5:51:58
* @Desc 
*/
@Service
public class SpringMvcHelloServiceImpl implements HelloService {
	private static RestTemplate restTemplate = RestTemplateBuilder.create();

	private static final String HELLO_URL = "cse://calculate-service/hello/sayHello?name=%s";

	public String sayHello(String name) {
		try {
			return restTemplate.getForObject(String.format(HELLO_URL, name), String.class);
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
