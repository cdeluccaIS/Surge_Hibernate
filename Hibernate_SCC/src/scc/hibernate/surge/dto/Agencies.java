package scc.hibernate.surge.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Agencies")
public class Agencies {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="agency_name")
	private String agency_name;
	@Column (name="agency_code")
	private String agency_code = "default";
	@Column (name="location_id")
	private String location_id;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public String getAgency_code() {
		return agency_code;
	}
	public void setAgency_code(String agency_code) {
		this.agency_code = agency_code;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	

}
