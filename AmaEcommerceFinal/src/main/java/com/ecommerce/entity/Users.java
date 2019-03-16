package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users implements Serializable{

private static final long serialVersionUID = 1L;
	
	public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	
	
	/*@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;*/
	
	
	
	/*commented for testing*/
	/*private String ctUserName;
	private String ctfirstName;
	private String ctlastName;
	private String ctroom;
	private String ctbuilding;
	
	@Lob //this can hold large texts(large object texts).should be used for description in suppliers (Reference)
	private String ctaddress1;
	
	private String ctaddress2;
	private String ctcity;
	private String ctState;
	private long ctPostalCode;
	private String ctCountry;
	private double ctPhone;
	private String ctEmail;
	private String ctVoiceMail;
	//private String ctPassword;
	private long ctCreditcard;
	private String ctCreditCardTypeID;
	private int ctCardExpMo;
	private long ctCardExpYr;
	private String ctBillingAdress;
	private String ctBillingCity;
	private String ctBillingRegion;
	private long ctBillingPostalCode;
	private String ctBillingCountry;
	private String ctShipAddress;
	private String ctShipCity;
	private String ctShipRegion;
	private long ctShipPostalCode;
	private String ctShipCountry;
	
	@Temporal (TemporalType.DATE)//Added just to record date w/o time
	private Date ctDateEntered;
	
	@Temporal (TemporalType.TIME)//will only record time
	private Date ctTimeEntered;*/
	
	/*commented for testing*/
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String username;
	private String password;
	private String emailId;
	private double phone;
	private int active;
	@ManyToMany
	@JoinTable(name = "userrolemapping", 
	joinColumns ={ 
			@JoinColumn(name = "user_id", referencedColumnName="id")}, 
			inverseJoinColumns = {
					@JoinColumn(name = "role_id")})
	private Set<UserRole> roles;
	
	private String firstName;
	private String lastName;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}



	public void setActive(int active) {
		this.active = active;
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
	
	
	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	/*@Column(name = "id", length = 30, nullable = false)
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}*/

}
