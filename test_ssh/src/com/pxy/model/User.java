package com.pxy.model;

public class User {
	private int ID;
	private String userName;
	private String passWord;
	private String status;
	private String phone;
	private String addr;
	//邮箱，电话，地址，激活码
/*	private String email;
	
	private String code;*/
	public User() {
		super();
	}
	public User(String userName) {
		super();
		this.userName = userName;
	}
	
	public User(int iD, String userName, String passWord, String status,
			String phone, String addr) {
		super();
		ID = iD;
		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
		this.phone = phone;
		this.addr = addr;
	}
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/*public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}*/
	
}
