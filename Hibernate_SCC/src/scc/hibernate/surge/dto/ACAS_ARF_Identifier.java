package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_Identifier")
public class ACAS_ARF_Identifier{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="FQDN")
	private UUID fqdn;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getFqdn() {
		return fqdn;
	}
	public void setFqdn(UUID fqdn) {
		this.fqdn = fqdn;
	}
	
}
