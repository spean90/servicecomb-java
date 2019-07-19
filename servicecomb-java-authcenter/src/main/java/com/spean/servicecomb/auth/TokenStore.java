package com.spean.servicecomb.auth;
/** 
* @author siping_huang 
* @Date 2019年7月19日 下午5:06:25
* @Desc 
*/
public interface TokenStore {
	/**
	   * Generates a token embedded with the username provided.
	   * @param username the username of requested user.
	   * @return the generated token.
	   */
	  String generate(String username);

	  /**
	   * Parses a token if valid.
	   * Throws {@link TokenException} if the provided is not genuine.
	   * @param token the token.
	   * @return the username embedded in the token.
	   */
	  String parse(String token);
}
