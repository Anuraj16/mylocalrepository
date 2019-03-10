package com.ecommerce.compositeKey;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleMappingId implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long urmroleid;
	private String username;
	
	public UserRoleMappingId() {
		
	}
	
	public UserRoleMappingId(int urmroleid,String username){
		this.urmroleid=urmroleid;
		this.username=username;
	}
	
	public long getUrmroleid() {
		return urmroleid;
	}
	public void setUrmroleid(long urmroleid) {
		this.urmroleid = urmroleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
