package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_NETCONFIG")
public class ACAS_ARF_NETCONFIG{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="netintid")
	private UUID netintid;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getNetintid() {
		return netintid;
	}
	public void setNetintid(UUID netintid) {
		this.netintid = netintid;
	}
}
