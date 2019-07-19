package com.spean.servicecomb.auth;

/**
 * @author siping_huang
 * @Date 2019年7月19日 下午5:15:51
 * @Desc
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	private final TokenStore tokenStore;

	AuthenticationServiceImpl(TokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}

	@Override
	public String authenticate(String username, String password) {
		if (!"000000".equals(password)) {
			throw new UnauthorizedAccessException("No user matches username " + username + " and password");
		}
		return tokenStore.generate(username);
	}

	@Override
	public String validate(String token) {
		try {
			return tokenStore.parse(token);
		} catch (TokenException e) {
			throw new UnauthorizedAccessException("No user matches such a token " + token, e);
		}
	}

}
