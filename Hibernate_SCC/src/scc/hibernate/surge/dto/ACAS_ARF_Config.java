package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ARF_Config")
public class ACAS_ARF_Config{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="networkConfig")
	private ACAS_ARF_NETCONFIG networkConfig;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cpeInv")
	private ACAS_ARF_cpeRecord cpeInv;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ARF_NETCONFIG getNetworkConfig() {
		return networkConfig;
	}
	public void setNetworkConfig(ACAS_ARF_NETCONFIG networkConfig) {
		this.networkConfig = networkConfig;
	}
	public ACAS_ARF_cpeRecord getCpeInv() {
		return cpeInv;
	}
	public void setCpeInv(ACAS_ARF_cpeRecord cpeInv) {
		this.cpeInv = cpeInv;
	}
}
