package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_BenchMarkID")
public class ACAS_ASR_BenchMarkID{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="resource")
	private String resource;
	@Column (name="record_identifier")
	private String record_identifier;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getRecord_identifier() {
		return record_identifier;
	}
	public void setRecord_identifier(String record_identifier) {
		this.record_identifier = record_identifier;
	}
}
