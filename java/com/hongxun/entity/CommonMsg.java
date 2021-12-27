package com.hongxun.entity;

import com.hongxun.enums.CommonStatus;

public class CommonMsg {
	private CommonStatus status;
	private String msg;

	public CommonMsg(CommonStatus status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public CommonStatus getStatus() {
		return status;
	}

	public void setStatus(CommonStatus status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}