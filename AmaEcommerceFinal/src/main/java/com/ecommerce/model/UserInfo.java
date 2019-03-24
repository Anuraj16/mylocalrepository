package com.ecommerce.model;

import java.util.List;

public class UserInfo {

private String username;
private String password;
private Long ispassworddefault;
private String firstName;
private String lastName;
private String emailId;
private double phone;

public UserInfo() {

}
public UserInfo(String userName, String password,Long ispassworddefault,String firstName ,String lastName,String emailId,double phone){
this.username = userName;
this.password = password;
this.ispassworddefault = ispassworddefault;
this.firstName=firstName;
this.lastName=lastName;
this.emailId=emailId;
this.phone=phone;
}



public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}
public Long getIspassworddefault() {
return ispassworddefault;
}
public void setIspassworddefault(Long ispassworddefault) {
this.ispassworddefault = ispassworddefault;
}
@Override
public String toString() {
return "UserInfo [userName=" + username + ", password=" + password
+ ", ispassworddefault=" + ispassworddefault + "]";
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public double getPhone() {
	return phone;
}
public void setPhone(double phone) {
	this.phone = phone;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
