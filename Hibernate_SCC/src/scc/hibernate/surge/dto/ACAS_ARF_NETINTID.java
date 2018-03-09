package scc.hibernate.surge.dto;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_NETINTID")
public class ACAS_ARF_NETINTID{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="id")
	private String id;
	@Column (name="hostData")
	private UUID hostData;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UUID getHostData() {
		return hostData;
	}
	public void setHostData(UUID hostData) {
		this.hostData = hostData;
	}
}
