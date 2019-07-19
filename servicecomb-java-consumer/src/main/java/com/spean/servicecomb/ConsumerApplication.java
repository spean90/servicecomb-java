package com.spean.servicecomb;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
* @author siping_huang 
* @Date 2019年7月18日 下午3:08:53
* @Desc 
*/
@SpringBootApplication
@EnableServiceComb
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
