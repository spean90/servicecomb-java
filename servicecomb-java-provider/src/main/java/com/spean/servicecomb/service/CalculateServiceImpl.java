package com.spean.servicecomb.service;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spean.servicecomb.CalculateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/** 
* @author siping_huang 
* @Date 2019年7月18日 上午10:52:03
* @Desc 
*/
@Api(tags= {"计算能力"})
@RestSchema(schemaId="calculateservice")
@RequestMapping("calculate")
public class CalculateServiceImpl implements CalculateService {

	@ApiOperation("加法")
	@ApiImplicitParams({
		@ApiImplicitParam(name="a",value="参数a",dataType="integer",paramType="query"),
		@ApiImplicitParam(name="b",value="参数b",dataType="integer",paramType="query")
	})
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public int add(int a, int b) {
		System.out.println(a+b);
		return a+b;
	}

}
