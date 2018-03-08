package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_PlatformName")
public class ACAS_ARF_PlatformName{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="assessedname")
	private UUID assessedname;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getAssessedname() {
		return assessedname;
	}
	public void setAssessedname(UUID assessedname) {
		this.assessedname = assessedname;
	}
}
