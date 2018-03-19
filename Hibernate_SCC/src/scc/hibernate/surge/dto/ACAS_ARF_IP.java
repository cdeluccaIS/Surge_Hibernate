package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_IP")
public class ACAS_ARF_IP{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="IPV4")
	private String ipv4  = "xxx.xxx.xxx.xxx";
	@Column (name="IPV6")
	private String ipv6 = "ffff.ffff.ffff.ffff.ffff.ffff.ffff.ffff";
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getIpv4() {
		return ipv4;
	}
	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}
	public String getIpv6() {
		return ipv6;
	}
	public void setIpv6(String ipv6) {
		this.ipv6 = ipv6;
	}
}
