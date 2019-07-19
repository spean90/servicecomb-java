package com.spean.servicecomb.auth.endpoint;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * @author siping_huang
 * @Date 2019年7月19日 下午5:24:33
 * @Desc
 */
@Component
class AuthorizationHeaderGenerator {

	static final String TOKEN_PREFIX = "Bearer ";

	HttpHeaders generate(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, TOKEN_PREFIX + token);
		return headers;
	}
}
