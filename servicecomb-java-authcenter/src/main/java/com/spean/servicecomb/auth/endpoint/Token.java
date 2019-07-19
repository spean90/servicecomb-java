package com.spean.servicecomb.auth.endpoint;
/** 
* @author siping_huang 
* @Date 2019年7月19日 下午5:26:59
* @Desc 
*/
class Token {
	  private String token;

	  Token() {
	  }

	  Token(String token) {
	    this.token = token;
	  }

	  public String getToken() {
	    return token;
	  }

	  @Override
	  public String toString() {
	    return "Token{" +
	        "token='" + token + '\'' +
	        '}';
	  }
	}