package scc.hibernate.surge.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="State")
public class State {
	@Id
	private UUID uuid;
	private String name = "--";
	@Column(name="ENABLED_FLAG", length=2, columnDefinition="CHAR")
	private String abbr = "XX";
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
