package com.ecommerce.model;


public class UserInfo {

private String username;
private String password;
private Long ispassworddefault;
private String firstName;
private String lastName;
private String emailId;
private String phone;
private boolean valid;
private String country;
private String address;
private String city;
private String pinCode;
private String[] UserType;


public UserInfo() {

}
public UserInfo(String userName, String password,Long ispassworddefault,String firstName ,String lastName,String emailId,String phone){
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPinCode() {
	return pinCode;
}
public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String[] getUserType() {
	return UserType;
}
public void setUserType(String[] userType) {
	UserType = userType;
}

}
