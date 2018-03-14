package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_ReportObject")
public class ACAS_ARF_ReportObject {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="device")
	private UUID device;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getDevice() {
		return device;
	}
	public void setDevice(UUID device) {
		this.device = device;
	}
}