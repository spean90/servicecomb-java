package com.spean.servicecomb.common;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author siping_huang
 * @Date 2018年12月14日 下午2:07:40
 * @Desc  返回结构体
 * @param <T>
 */
public class RespObj<T> implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="业务状态码")
	private int ret;
	@ApiModelProperty(value="错误信息")
	private String msg;
	private T data;
	
	public RespObj( ) {
		this.ret = 0;
		this.msg = "success";
	}
	public RespObj(T data) {
		this();
		this.data = data;
	}
	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
