package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="ACAS_ARF_cpeRecord")
public class ACAS_ARF_cpeRecord{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="platformName")
	private ACAS_ARF_PlatformName platformName;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ARF_PlatformName getPlatformName() {
		return platformName;
	}
	public void setPlatformName(ACAS_ARF_PlatformName platformName) {
		this.platformName = platformName;
	}
}
