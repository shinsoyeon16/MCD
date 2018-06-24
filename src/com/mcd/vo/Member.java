package com.mcd.vo;

public class Member {
	private String id;
	private String passwd;
	private String name;
	private String phoneNumber;
	private int money;
	
	public Member() {
	}
	public Member(String id, String passwd, String name, String phoneNumber) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

}
