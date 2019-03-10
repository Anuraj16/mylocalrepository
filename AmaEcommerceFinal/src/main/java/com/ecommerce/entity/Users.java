package com.ecommerce.entity;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
	private String userName;
	private String password;
	private String emailId;
	private double phone;
	private int active;
	private HashSet<UserRole> roles;
	private String firstName;
	private String lastName;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters from here
	/*public int getCtCustomerId() {
		return ctCustomerId;
	}



	public void setCtCustomerId(int ctCustomerId) {
		this.ctCustomerId = ctCustomerId;
	}



	public String getCtUserName() {
		return ctUserName;
	}



	public void setCtUserName(String ctUserName) {
		this.ctUserName = ctUserName;
	}



	public String getCtfirstName() {
		return ctfirstName;
	}



	public void setCtfirstName(String ctfirstName) {
		this.ctfirstName = ctfirstName;
	}



	public String getCtlastName() {
		return ctlastName;
	}



	public void setCtlastName(String ctlastName) {
		this.ctlastName = ctlastName;
	}



	public String getCtroom() {
		return ctroom;
	}



	public void setCtroom(String ctroom) {
		this.ctroom = ctroom;
	}



	public String getCtbuilding() {
		return ctbuilding;
	}



	public void setCtbuilding(String ctbuilding) {
		this.ctbuilding = ctbuilding;
	}



	public String getCtaddress1() {
		return ctaddress1;
	}



	public void setCtaddress1(String ctaddress1) {
		this.ctaddress1 = ctaddress1;
	}



	public String getCtaddress2() {
		return ctaddress2;
	}



	public void setCtaddress2(String ctaddress2) {
		this.ctaddress2 = ctaddress2;
	}



	public String getCtcity() {
		return ctcity;
	}



	public void setCtcity(String ctcity) {
		this.ctcity = ctcity;
	}



	public String getCtState() {
		return ctState;
	}



	public void setCtState(String ctState) {
		this.ctState = ctState;
	}



	public long getCtPostalCode() {
		return ctPostalCode;
	}



	public void setCtPostalCode(long ctPostalCode) {
		this.ctPostalCode = ctPostalCode;
	}



	public String getCtCountry() {
		return ctCountry;
	}



	public void setCtCountry(String ctCountry) {
		this.ctCountry = ctCountry;
	}



	public double getCtPhone() {
		return ctPhone;
	}



	public void setCtPhone(double ctPhone) {
		this.ctPhone = ctPhone;
	}



	public String getCtEmail() {
		return ctEmail;
	}



	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
	}



	public String getCtVoiceMail() {
		return ctVoiceMail;
	}



	public void setCtVoiceMail(String ctVoiceMail) {
		this.ctVoiceMail = ctVoiceMail;
	}



	public String getCtPassword() {
		return ctPassword;
	}



	public void setCtPassword(String ctPassword) {
		this.ctPassword = ctPassword;
	}



	public long getCtCreditcard() {
		return ctCreditcard;
	}



	public void setCtCreditcard(long ctCreditcard) {
		this.ctCreditcard = ctCreditcard;
	}



	public String getCtCreditCardTypeID() {
		return ctCreditCardTypeID;
	}



	public void setCtCreditCardTypeID(String ctCreditCardTypeID) {
		this.ctCreditCardTypeID = ctCreditCardTypeID;
	}



	public int getCtCardExpMo() {
		return ctCardExpMo;
	}



	public void setCtCardExpMo(int ctCardExpMo) {
		this.ctCardExpMo = ctCardExpMo;
	}



	public long getCtCardExpYr() {
		return ctCardExpYr;
	}



	public void setCtCardExpYr(long ctCardExpYr) {
		this.ctCardExpYr = ctCardExpYr;
	}



	public String getCtBillingAdress() {
		return ctBillingAdress;
	}



	public void setCtBillingAdress(String ctBillingAdress) {
		this.ctBillingAdress = ctBillingAdress;
	}



	public String getCtBillingCity() {
		return ctBillingCity;
	}



	public void setCtBillingCity(String ctBillingCity) {
		this.ctBillingCity = ctBillingCity;
	}



	public String getCtBillingRegion() {
		return ctBillingRegion;
	}



	public void setCtBillingRegion(String ctBillingRegion) {
		this.ctBillingRegion = ctBillingRegion;
	}



	public long getCtBillingPostalCode() {
		return ctBillingPostalCode;
	}



	public void setCtBillingPostalCode(long ctBillingPostalCode) {
		this.ctBillingPostalCode = ctBillingPostalCode;
	}



	public String getCtBillingCountry() {
		return ctBillingCountry;
	}



	public void setCtBillingCountry(String ctBillingCountry) {
		this.ctBillingCountry = ctBillingCountry;
	}



	public String getCtShipAddress() {
		return ctShipAddress;
	}



	public void setCtShipAddress(String ctShipAddress) {
		this.ctShipAddress = ctShipAddress;
	}



	public String getCtShipCity() {
		return ctShipCity;
	}



	public void setCtShipCity(String ctShipCity) {
		this.ctShipCity = ctShipCity;
	}



	public String getCtShipRegion() {
		return ctShipRegion;
	}



	public void setCtShipRegion(String ctShipRegion) {
		this.ctShipRegion = ctShipRegion;
	}



	public long getCtShipPostalCode() {
		return ctShipPostalCode;
	}



	public void setCtShipPostalCode(long ctShipPostalCode) {
		this.ctShipPostalCode = ctShipPostalCode;
	}



	public String getCtShipCountry() {
		return ctShipCountry;
	}



	public void setCtShipCountry(String ctShipCountry) {
		this.ctShipCountry = ctShipCountry;
	}



	public Date getCtDateEntered() {
		return ctDateEntered;
	}



	public void setCtDateEntered(Date ctDateEntered) {
		this.ctDateEntered = ctDateEntered;
	}



	
	
	public Users() {

	}

	

	public Users(String userName, String password) {
		this.setCtUserName(userName);
		this.setCtPassword(password);
	}



	public Date getCtTimeEntered() {
		return ctTimeEntered;
	}



	public void setCtTimeEntered(Date ctTimeEntered) {
		this.ctTimeEntered = ctTimeEntered;
	}*/

	@Column(name = "username", nullable = false)
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
	
	@OneToMany
	@JoinTable(name = "userrolemapping", joinColumns ={ @JoinColumn(name = "username")}, inverseJoinColumns = @JoinColumn(name = "id"))
	public HashSet<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(HashSet<UserRole> roles) {
		this.roles = roles;
	}


	/*@Column(name = "id", length = 30, nullable = false)
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}*/

}
