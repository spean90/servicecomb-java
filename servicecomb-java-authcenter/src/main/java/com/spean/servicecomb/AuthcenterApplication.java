package com.spean.servicecomb;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
* @author siping_huang 
* @Date 2019年7月19日 下午5:01:48
* @Desc 
*/
@SpringBootApplication
@EnableServiceComb
public class AuthcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthcenterApplication.class, args);
	}
}
