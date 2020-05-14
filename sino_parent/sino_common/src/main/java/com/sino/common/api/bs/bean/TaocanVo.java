package com.sino.common.api.bs.bean;

public class TaocanVo {
	//"net":"2G","openDate":"20150123040112","productId":"1039","productName":"328 预登录套餐","userId":"88270724"
	private String net;
	private String openDate;
	private String productId;
	private String productName;
	private String userId;
	
	
	
	
	
	public TaocanVo() {
		super();
	}
	public TaocanVo(String net) {
		super();
		this.net = net;
	}
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
