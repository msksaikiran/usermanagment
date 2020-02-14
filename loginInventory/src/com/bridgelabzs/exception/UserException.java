package com.bridgelabzs.exception;

public class UserException extends RuntimeException{

	private String msg;

	public UserException(String msg) {
		super();
		this.msg = msg;
	}

}
