package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ARF_Device")
public class ACAS_ARF_Device{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="deviceID")
	private ACAS_ARF_deviceID deviceID;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="identifiers")
	private ACAS_ARF_Identifier identifiers;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="op_attr")
	private ACAS_ARF_OPATTR op_attr;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="configuration")
	private ACAS_ARF_Config configuration;
	@Column (name="timestamp")
	private Date timestamp;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tagged")
	private ACAS_ARF_Tagged tagged;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ARF_deviceID getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(ACAS_ARF_deviceID deviceID) {
		this.deviceID = deviceID;
	}
	public ACAS_ARF_Identifier getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(ACAS_ARF_Identifier identifiers) {
		this.identifiers = identifiers;
	}
	public ACAS_ARF_OPATTR getOp_attr() {
		return op_attr;
	}
	public void setOp_attr(ACAS_ARF_OPATTR op_attr) {
		this.op_attr = op_attr;
	}
	public ACAS_ARF_Config getConfiguration() {
		return configuration;
	}
	public void setConfiguration(ACAS_ARF_Config configuration) {
		this.configuration = configuration;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public ACAS_ARF_Tagged getTagged() {
		return tagged;
	}
	public void setTagged(ACAS_ARF_Tagged tagged) {
		this.tagged = tagged;
	}
	
}
