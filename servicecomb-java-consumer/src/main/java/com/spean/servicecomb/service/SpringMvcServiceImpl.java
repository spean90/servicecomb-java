package com.spean.servicecomb.service;

import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spean.servicecomb.CalculateService;

/** 
* @author siping_huang 
* @Date 2019年7月18日 下午3:10:38
* @Desc 
*/
@Service
public class SpringMvcServiceImpl implements CalculateService {
	private static RestTemplate restTemplate = RestTemplateBuilder.create();

	private static final String ADD_URL = "cse://calculate-service/calculate/add?a=%d&b=%d";
	public int add(int a, int b) {
		return restTemplate.getForObject(String.format(ADD_URL, a,b), Integer.class);
	}

}
