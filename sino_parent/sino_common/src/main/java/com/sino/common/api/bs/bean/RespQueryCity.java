package com.sino.common.api.bs.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//{"Phone":"13289287271","City":"西安","Province":"sx","Province1":"陕西"}
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class RespQueryCity {
	
	private String Phone;
	private String City;
	private String Province;
	private String Province1;
	private String Source;
	private String ASP;
	
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getProvince1() {
		return Province1;
	}
	public void setProvince1(String province1) {
		Province1 = province1;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getASP() {
		return ASP;
	}
	public void setASP(String aSP) {
		ASP = aSP;
	}
	
	
	
	
}
