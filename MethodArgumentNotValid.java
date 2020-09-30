package com.solelogic;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class MethodArgumentNotValid extends RuntimeException {
	private String msg;
	private HttpStatus status;
	private BindingResult result;

	public MethodArgumentNotValid(String msg, HttpStatus status, BindingResult result) {
		super();
		this.msg = msg;
		this.status = status;
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public BindingResult getResult() {
		return result;
	}

	public void setResult(BindingResult result) {
		this.result = result;
	}

}
