package com.spean.servicecomb.auth;

/**
 * @author siping_huang
 * @Date 2019年7月19日 下午5:18:21
 * @Desc
 */
public class UnauthorizedAccessException extends RuntimeException {

	public UnauthorizedAccessException(String message) {
		super(message);
	}

	public UnauthorizedAccessException(String message, Throwable e) {
		super(message, e);
	}
}
