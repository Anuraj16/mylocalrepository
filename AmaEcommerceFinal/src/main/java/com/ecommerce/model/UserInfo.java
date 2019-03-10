package com.ecommerce.model;

public class UserInfo {

private String userName;
private String password;
private Long ispassworddefault;

public UserInfo() {

}
public UserInfo(String userName, String password,Long ispassworddefault) {
this.userName = userName;
this.password = password;
this.ispassworddefault = ispassworddefault;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
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
return "UserInfo [userName=" + userName + ", password=" + password
+ ", ispassworddefault=" + ispassworddefault + "]";
}


}
