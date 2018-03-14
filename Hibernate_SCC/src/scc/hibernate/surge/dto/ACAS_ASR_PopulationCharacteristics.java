package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_PopulationCharacteristics")
public class ACAS_ASR_PopulationCharacteristics{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="resource")
	private String resource;
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
}
