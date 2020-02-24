package com.cg.go.bean;

public class User
{
private String userName;
private String passWord;
private String reenterPassword;
private String email;
private String phoneNum;
private boolean status;
public User(String userName, String passWord, String email, String phoneNum, boolean status) {
	super();
	this.userName = userName;
	this.passWord = passWord;
	this.reenterPassword = reenterPassword;
	this.email = email;
	this.phoneNum = phoneNum;
	this.status = status;
}
public User()
{
	super();

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
public String getReenterPassword() {
	return reenterPassword;
}
public void setReenterPassword(String reenterPassword) {
	this.reenterPassword = reenterPassword;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}




}