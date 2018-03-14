package scc.hibernate.surge.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Country")
public class Country {
	@Id
	private UUID uuid;
	private String name = "--";
	@Column(name="abbr", columnDefinition="char(3)")
	private String abbr = "---";
	public Country(){
	}
	public Country(String name, String abbr){
		this.name = name;
		this.abbr = abbr;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
}
