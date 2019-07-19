package com.spean.servicecomb.auth;

import java.time.ZonedDateTime;
import java.util.Date;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author siping_huang
 * @Date 2019年7月19日 下午5:06:55
 * @Desc
 */
public class JwtTokenStore implements TokenStore {

	private final String secretKey;
	private final int secondsToExpire;
	
	JwtTokenStore(String secretKey, int secondsToExpire) {
	    this.secretKey = secretKey;
	    this.secondsToExpire = secondsToExpire;
	  }

	public String generate(String username) {
		 return Jwts.builder()
			        .setSubject(username)
			        .setExpiration(Date.from(ZonedDateTime.now().plusSeconds(secondsToExpire).toInstant()))
			        .signWith(SignatureAlgorithm.HS512, secretKey)
			        .compact();
	}

	public String parse(String token) {
		 try {
		      return Jwts.parser()
		          .setSigningKey(secretKey)
		          .parseClaimsJws(token)
		          .getBody()
		          .getSubject();
		    } catch (JwtException | IllegalArgumentException e) {
		      throw new TokenException(e);
		    }
	}

}
