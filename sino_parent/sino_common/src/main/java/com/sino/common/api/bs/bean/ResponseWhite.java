package com.sino.common.api.bs.bean;

public class ResponseWhite {
	//{"data":"13289287271|129","message":"","result":"true"}
	private boolean result;
	private String message;
	private String data;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
