package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="ACAS_ARF_Identifier")
public class ACAS_ARF_Identifier{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="FQDN")
	private ACAS_ARF_ID_FQDN fqdn;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ARF_ID_FQDN getFqdn() {
		return fqdn;
	}
	public void setFqdn(ACAS_ARF_ID_FQDN fqdn) {
		this.fqdn = fqdn;
	}
	
}
