package com.employee.hibernate;
import java.util.UUID;

public class Account {
	private UUID uuid;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String Email;
    private String securePhone;
    private String uSecurePhone;
    private UUID agency;
    private UUID citizenship;
    private String clearance;
    private String Address1;
    private String Address2;
    private String City;
    private UUID State;
    private int ZipCode;
    private String accountType;
    private String accountStatus;
    private String password;
    private boolean lock;
    
    public Account() {}
    public Account(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
	public UUID getAgency() {
		return agency;
	}
	public void setAgency(UUID agency) {
		this.agency = agency;
	}
	public UUID getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(UUID citizenship) {
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
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public UUID getState() {
		return State;
	}
	public void setState(UUID state) {
		State = state;
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
