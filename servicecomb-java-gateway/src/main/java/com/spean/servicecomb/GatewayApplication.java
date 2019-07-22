package com.spean.servicecomb;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author siping_huang
 * @Date 2019年7月22日 上午11:17:25
 * @Desc
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableServiceComb
public class GatewayApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
