package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_Device")
public class ACAS_ARF_Device{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="deviceID")
	private UUID deviceID;
	@Column (name="identifiers")
	private UUID identifiers;
	@Column (name="op_attr")
	private UUID op_attr;
	@Column (name="configuration")
	private UUID configuration;
	@Column (name="timestamp")
	private long timestamp;
	@Column (name="tagged")
	private UUID tagged;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(UUID deviceID) {
		this.deviceID = deviceID;
	}
	public UUID getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(UUID identifiers) {
		this.identifiers = identifiers;
	}
	public UUID getOp_attr() {
		return op_attr;
	}
	public void setOp_attr(UUID op_attr) {
		this.op_attr = op_attr;
	}
	public UUID getConfiguration() {
		return configuration;
	}
	public void setConfiguration(UUID configuration) {
		this.configuration = configuration;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public UUID getTagged() {
		return tagged;
	}
	public void setTagged(UUID tagged) {
		this.tagged = tagged;
	}
	
}