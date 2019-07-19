package com.spean.servicecomb.common;

public class ResultUtil {

	 public static  <T> RespObj<T> success(T t) {
		    RespObj<T> result = new RespObj<T>();
	        result.setRet(0);
	        result.setMsg("成功");
	        result.setData(t);
	        return result;
	    }

	    public static <T> RespObj<T> success() {
	        return success(null);
	    }

	    public static RespObj<Object> error(Integer code, String msg) {
	    	RespObj<Object> result = new RespObj<Object>();
	        result.setRet(code);
	        result.setMsg(msg);
	        return result;
	    }
	    
}
