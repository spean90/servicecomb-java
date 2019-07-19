package com.spean.servicecomb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spean.servicecomb.common.RespObj;
import com.spean.servicecomb.common.ResultUtil;
import com.spean.servicecomb.service.SpringMvcHelloServiceImpl;
import com.spean.servicecomb.service.SpringMvcServiceImpl;

/** 
* @author siping_huang 
* @Date 2019年7月18日 下午3:12:32
* @Desc 
*/
@RestController
public class ComsumerController {

	@Autowired
	SpringMvcServiceImpl springMvcServiceImpl;
	@Autowired
	SpringMvcHelloServiceImpl springMvcHelloServiceImpl;
	
	@RequestMapping(value="mvc",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RespObj<?> mvc(int a,int b) {
		return ResultUtil.success(springMvcServiceImpl.add(a, b));
	}
	@RequestMapping(value="hello",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RespObj<?> hello(String name) {
		return ResultUtil.success(springMvcHelloServiceImpl.sayHello(name));
	}
}
