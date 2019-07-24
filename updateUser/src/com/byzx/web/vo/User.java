package com.byzx.web.vo;

public class User {
	private int uid;
	private String uname;
	private String password;
	private String sex;
	private int age;
	private String address;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {}
	//构造向数据库添加一条数据的方法
	public User(String uname, String password, String sex, int age, String address) {
		super();
		this.uname = uname;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}
	
	public User(int uid, String uname, String sex, int age, String address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", sex=" + sex + ", age=" + age
				+ ", address=" + address + "]";
	}
	
	
}
