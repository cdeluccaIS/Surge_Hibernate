package scc.hibernate.surge.dto;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="ACAS_ARF_NETINTID")
public class ACAS_ARF_NETINTID{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="id")
	private String id;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="hostData")
	private ACAS_ARF_HOSTDATA hostData;
	
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
	public ACAS_ARF_HOSTDATA getHostData() {
		return hostData;
	}
	public void setHostData(ACAS_ARF_HOSTDATA hostData) {
		this.hostData = hostData;
	}
}
