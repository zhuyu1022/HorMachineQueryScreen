package com.hoperun.hormachine.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UpdateInfoBizData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String Code = "";

	private String Message = "";

	private  UpdateInfo Result;

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

	public  UpdateInfo getResult() {
		return Result;
	}

	public void setResult( UpdateInfo result) {
		Result = result;
	}

	public class  UpdateInfo {
		
		private  String VersionNo ="";//版本号
		private  String URL ="";//下载路径
		public String getVersionNo() {
			return VersionNo;
		}
		public void setVersionNo(String versionNo) {
			VersionNo = versionNo;
		}
		public String getURL() {
			return URL;
		}
		public void setURL(String uRL) {
			URL = uRL;
		}

		
	}
		
}
