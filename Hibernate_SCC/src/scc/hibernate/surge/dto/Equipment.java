package scc.hibernate.surge.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Equipment")
public class Equipment {
		@Id
		@Column (name="uuid")
	    private UUID uuid;
		@Column (name="hostname", length=48)
	    private String hostname;
		@Column (name="ipv4", length=15)
	    private char ipv4;
		@Column (name="ipv6", length=48)
	    private String ipv6;
		@Column (name="macAddress", length=17)
	    private String macAddress;
		@Column (name="os", length=512)
	    private String os;
		@Column (name="domain", length=48)
	    private String domain;
		public UUID getUuid() {
			return uuid;
		}
		public void setUuid(UUID uuid) {
			this.uuid = uuid;
		}
		public String getHostname() {
			return hostname;
		}
		public void setHostname(String hostname) {
			this.hostname = hostname;
		}
		public char getIpv4() {
			return ipv4;
		}
		public void setIpv4(char ipv4) {
			this.ipv4 = ipv4;
		}
		public String getIpv6() {
			return ipv6;
		}
		public void setIpv6(String ipv6) {
			this.ipv6 = ipv6;
		}
		public String getMacAddress() {
			return macAddress;
		}
		public void setMacAddress(String macAddress) {
			this.macAddress = macAddress;
		}
		public String getOs() {
			return os;
		}
		public void setOs(String os) {
			this.os = os;
		}
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
}
