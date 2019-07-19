package com.spean.servicecomb.service;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spean.servicecomb.HelloService;

/** 
* @author siping_huang 
* @Date 2019年7月18日 下午5:50:19
* @Desc 
*/
@RestSchema(schemaId="helloservice")
@RequestMapping("hello")
public class HelloServiceImpl implements HelloService {

	@GetMapping(value="/sayHello")
	public String sayHello(String name) {
		return "hello:"+name;
	}

}
