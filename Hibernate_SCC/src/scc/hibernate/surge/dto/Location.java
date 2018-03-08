package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Location")
public class Location {
	@Id
	private UUID uuid;
	private String location_name = "--";
	private String location_id = "--";
	private String address1 = "--";
	private String address2 = "--";
	private String city = "--";
	private UUID state;
	private int zip_code;
	
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
	public UUID getState() {
		return state;
	}
	public void setState(UUID state) {
		this.state = state;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
	

}