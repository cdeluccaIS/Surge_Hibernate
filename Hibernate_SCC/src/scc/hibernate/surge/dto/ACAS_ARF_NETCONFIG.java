package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="ACAS_ARF_NETCONFIG")
public class ACAS_ARF_NETCONFIG{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="netintid")
	private ACAS_ARF_NETINTID netintid;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ARF_NETINTID getNetintid() {
		return netintid;
	}
	public void setNetintid(ACAS_ARF_NETINTID netintid) {
		this.netintid = netintid;
	}
}
