package com.spean.servicecomb;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
* @author siping_huang 
* @Date 2019年7月18日 上午10:44:19
* @Desc 
*/
@SpringBootApplication
@EnableServiceComb
public class ProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvideApplication.class, args);
	}
}
