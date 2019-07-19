package com.spean.servicecomb.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author siping_huang
 * @Date 2019年7月19日 下午5:19:05
 * @Desc
 */
@Configuration
class AuthenticationConfig {

	private static final int SECONDS_OF_A_DAY = 24 * 60 * 60;
	private static final String SECRET_KEY = "secretKey";

	@Bean
	AuthenticationService authenticationService(TokenStore tokenStore) {

		return new AuthenticationServiceImpl(tokenStore);
	}

	@Bean
	TokenStore tokenStore() {
		return new JwtTokenStore(SECRET_KEY, SECONDS_OF_A_DAY);
	}
}
