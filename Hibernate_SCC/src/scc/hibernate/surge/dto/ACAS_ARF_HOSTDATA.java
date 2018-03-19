package scc.hibernate.surge.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ARF_HOSTDATA")
public class ACAS_ARF_HOSTDATA{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="macAddress")
	private String macAddress;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    	@JoinColumn(name="connectionIP")
	private ACAS_ARF_IP connectionIP;
	
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
	public ACAS_ARF_IP getConnectionIP() {
		return connectionIP;
	}
	public void setConnectionIP(ACAS_ARF_IP connectionIP) {
		this.connectionIP = connectionIP;
	}
}
