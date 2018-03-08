package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ARF_AR")
public class ACAS_ARF_AR{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="xmlns:ar")
	private String xmlns_ar;
	@Column (name="xmlns:device")
	private String xmlns_device;
	@Column (name="xmlns:cpe")
	private String xmlns_cpe;
	@Column (name="xmlns:tagValue")
	private String xmlns_tagValue;
	@Column (name="xmlns:cndc")
	private String xmlns_cndc;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getXmlns_ar() {
		return xmlns_ar;
	}
	public void setXmlns_ar(String xmlns_ar) {
		this.xmlns_ar = xmlns_ar;
	}
	public String getXmlns_device() {
		return xmlns_device;
	}
	public void setXmlns_device(String xmlns_device) {
		this.xmlns_device = xmlns_device;
	}
	public String getXmlns_cpe() {
		return xmlns_cpe;
	}
	public void setXmlns_cpe(String xmlns_cpe) {
		this.xmlns_cpe = xmlns_cpe;
	}
	public String getXmlns_tagValue() {
		return xmlns_tagValue;
	}
	public void setXmlns_tagValue(String xmlns_tagValue) {
		this.xmlns_tagValue = xmlns_tagValue;
	}
	public String getXmlns_cndc() {
		return xmlns_cndc;
	}
	public void setXmlns_cndc(String xmlns_cndc) {
		this.xmlns_cndc = xmlns_cndc;
	}
	
}
