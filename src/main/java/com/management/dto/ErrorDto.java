package com.management.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6707257769269912351L;
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ErrorDto(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ErrorDto [msg=" + msg + "]";
	}
	

}
