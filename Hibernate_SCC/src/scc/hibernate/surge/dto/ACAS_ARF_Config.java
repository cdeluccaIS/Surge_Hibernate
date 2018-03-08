package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_Config")
public class ACAS_ARF_Config{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="networkConfig")
	private UUID networkConfig;
	@Column (name="cpeInv")
	private UUID cpeInv;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getNetworkConfig() {
		return networkConfig;
	}
	public void setNetworkConfig(UUID networkConfig) {
		this.networkConfig = networkConfig;
	}
	public UUID getCpeInv() {
		return cpeInv;
	}
	public void setCpeInv(UUID cpeInv) {
		this.cpeInv = cpeInv;
	}
}