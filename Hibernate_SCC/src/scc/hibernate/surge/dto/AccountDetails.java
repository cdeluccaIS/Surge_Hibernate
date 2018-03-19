package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity (name="Account")
public class AccountDetails {
	@Id
	@Column (name="uuid")
    private UUID uuid;
	@Column (name="firstName")
    private String firstName;
	@Column (name="middleInitial")
    private char middleInitial = '?';
	@Column (name="lastName")
    private String lastName;
	@Column (name="Email")
    private String Email;
	@Column (name="securePhone")
    private String securePhone;
	@Column (name="uSecurePhone")
    private String uSecurePhone = "--";
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    	@JoinColumn(name="agency")
    private Agencies agency;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="citizenship")
    private Country citizenship;
	@Column (name="clearance")
    private String clearance;
	@Column (name="Address1")
    private String Address1 = "--";
	@Column (name="Address2")
    private String Address2 = "--";
	@Column (name="City")
    private String city = "--";
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="state")
    private State state;
	@Column (name="ZipCode")
    private int ZipCode = 12345;
	@Column (name="accountType")
    private String accountType;
	@Column (name="accountStatus")
    private String accountStatus;
	@Column (name="password")
    private String password;
	@Column (name="lock")
    private boolean lock;
	public AccountDetails(){
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSecurePhone() {
		return securePhone;
	}
	public void setSecurePhone(String securePhone) {
		this.securePhone = securePhone;
	}
	public String getuSecurePhone() {
		return uSecurePhone;
	}
	public void setuSecurePhone(String uSecurePhone) {
		this.uSecurePhone = uSecurePhone;
	}
	public Agencies getAgency() {
		return agency;
	}
	public void setAgency(Agencies agency) {
		this.agency = agency;
	}
	public Country getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(Country citizenship) {
		this.citizenship = citizenship;
	}
	public String getClearance() {
		return clearance;
	}
	public void setClearance(String clearance) {
		this.clearance = clearance;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
	}
    
}
