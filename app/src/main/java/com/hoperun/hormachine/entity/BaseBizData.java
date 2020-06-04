package com.hoperun.hormachine.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseBizData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Code = "";

	private String Message = "";

	private Object Result;

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public Object getResult() {
		return Result;
	}

	public void setResult(Object result) {
		Result = result;
	}


}
