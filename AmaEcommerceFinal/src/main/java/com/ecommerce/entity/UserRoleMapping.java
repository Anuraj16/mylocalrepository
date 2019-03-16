package com.ecommerce.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.ecommerce.compositeKey.UserRoleMappingId;
@Entity
@Table(name="userrolemapping")
public class UserRoleMapping {
	
	@EmbeddedId
	@AttributeOverrides({
	@AttributeOverride(name="role_id",column = @Column(name = "role_id", nullable = false)),
	@AttributeOverride(name = "user_id", column = @Column(name = "user_id", nullable = false))
	})
	private UserRoleMappingId userRoleMappingId;

	
	/*@Column(name = "user_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;*/
	
	//private int rowstate;
	
	public UserRoleMapping() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRoleMapping(UserRoleMappingId userRoleMappingId) {
		this.userRoleMappingId=userRoleMappingId;
	}
	
	public UserRoleMappingId getUserRoleMappingId() {
		return userRoleMappingId;
	}

	public void setUserRoleMappingId(UserRoleMappingId userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	/*public int getRowstate() {
		return rowstate;
	}

	public void setRowstate(int rowstate) {
		this.rowstate = rowstate;
	}*/

}
