package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_HOSTDATA")
public class ACAS_ARF_HOSTDATA{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="macAddress")
	private String macAddress;
	@Column (name="connectionIP")
	private UUID connectionIP;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public UUID getConnectionIP() {
		return connectionIP;
	}
	public void setConnectionIP(UUID connectionIP) {
		this.connectionIP = connectionIP;
	}
}
