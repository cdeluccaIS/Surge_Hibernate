package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_cpeRecord")
public class ACAS_ARF_cpeRecord{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="platformName")
	private UUID platformName;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getPlatformName() {
		return platformName;
	}
	public void setPlatformName(UUID platformName) {
		this.platformName = platformName;
	}
}
