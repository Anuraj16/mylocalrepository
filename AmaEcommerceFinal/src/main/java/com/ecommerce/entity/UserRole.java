package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seq",initialValue=1,allocationSize=100)
@Table (name="userrole")
public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
	
	private int role_id;
	//private Users user;
	private String userRole;
	private Long rowstate ;
	private Set<Users> users;

	@Id
	@Column(name = "role_id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "strusername")
	// @JoinColumns({
	// @JoinColumn(name = "strusername"),
	// @JoinColumn(name = "struid")
	// })
*/
	/*public Users getUser() {
	return user;
	}

	public void setUser(Users user) {
	this.user = user;
	}*/

	@Column(name = "roleName", length = 30, nullable = false)
	public String getUserRole() {
	return userRole;
	}

	public void setUserRole(String userRole) {
	this.userRole = userRole;
	}

	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	public Long getRowstate() {
	return rowstate;
	}

	public void setRowstate(Long rowstate) {
	this.rowstate = rowstate;
	}
	
	@ManyToMany(mappedBy = "roles")
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
}
