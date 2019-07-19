package com.spean.servicecomb.auth;
/** 
* @author siping_huang 
* @Date 2019年7月19日 下午5:15:23
* @Desc 
*/
public interface AuthenticationService {
	
	  String authenticate(String username, String password);

	  String validate(String token);

}
