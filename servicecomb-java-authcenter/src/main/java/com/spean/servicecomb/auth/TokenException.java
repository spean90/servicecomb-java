package com.spean.servicecomb.auth;
/** 
* @author siping_huang 
* @Date 2019年7月19日 下午5:13:25
* @Desc 
*/
public class TokenException extends RuntimeException {
	public TokenException(Throwable throwable) {
	    super(throwable);
	  }

	  public TokenException() {

	  }
}
