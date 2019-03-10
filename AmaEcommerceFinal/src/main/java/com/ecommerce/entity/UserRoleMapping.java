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
/*@Entity
@Table(name="userrolemapping")*/
public class UserRoleMapping {
	
	@EmbeddedId
	@AttributeOverrides({
	@AttributeOverride(name="urmroleid",column = @Column(name = "urmroleid", nullable = false)),
	@AttributeOverride(name = "username", column = @Column(name = "urmusername", nullable = false))
	})
	private UserRoleMappingId userRoleMappingId;

	
	@Column(name = "urmid", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int rowstate;
	
	public UserRoleMapping() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRoleMapping(UserRoleMappingId userRoleMappingId,int id) {
		this.userRoleMappingId=userRoleMappingId;
		this.id=id;
	}
	
	public UserRoleMappingId getUserRoleMappingId() {
		return userRoleMappingId;
	}

	public void setUserRoleMappingId(UserRoleMappingId userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRowstate() {
		return rowstate;
	}

	public void setRowstate(int rowstate) {
		this.rowstate = rowstate;
	}

}
