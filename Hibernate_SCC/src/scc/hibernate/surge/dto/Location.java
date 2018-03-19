package scc.hibernate.surge.dto;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="Location")
public class Location {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="location_name")
	private String location_name;
	@Column (name="location_id")
	private String location_id;
	@Column (name="address1")
	private String address1 = "--";
	@Column (name="address2")
	private String address2 = "--";
	@Column (name="city")
	private String city = "--";
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    	@JoinColumn(name="state")
	private State state;
	@Column (name="zip_code")
	private int zip_code;
	
	public Location(){
	}
	public Location(String locName, String locId, String addr1, String addr2, String city, State state, int zipCode){
		this.location_name = locName;
		this.location_id = locId;
		this.address1 = addr1;
		this.address2 = addr2;
		this.city = city;
		this.state = state;
		this.zip_code = zipCode;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
	

}
