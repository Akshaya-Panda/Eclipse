package com.comviva.ocs.bean;

public class CredentialsBean {
	
	
	private String userid;
	private String password;
	private String usertype;
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	@Override
	public String toString() {
		return "CredentialsBean [userid=" + userid + ", password=" + password + ", usertype=" + usertype
				+"]";
	}
	
	
}
