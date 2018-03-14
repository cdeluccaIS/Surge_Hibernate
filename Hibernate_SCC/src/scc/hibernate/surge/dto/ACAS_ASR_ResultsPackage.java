package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_ResultsPackage")
public class ACAS_ASR_ResultsPackage{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="cndc")
	private String cndc;
	@Column (name="summRes")
	private String summRes;
	@Column (name="popCharac")
	private UUID popCharac;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getCndc() {
		return cndc;
	}
	public void setCndc(String cndc) {
		this.cndc = cndc;
	}
	public String getSummRes() {
		return summRes;
	}
	public void setSummRes(String summRes) {
		this.summRes = summRes;
	}
	public UUID getPopCharac() {
		return popCharac;
	}
	public void setPopCharac(UUID popCharac) {
		this.popCharac = popCharac;
	}
}
