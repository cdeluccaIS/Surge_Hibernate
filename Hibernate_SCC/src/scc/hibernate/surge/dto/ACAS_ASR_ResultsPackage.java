package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ASR_ResultsPackage")
public class ACAS_ASR_ResultsPackage{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="cndc")
	private String cndc;
	@Column (name="summRes")
	private String summRes;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="popCharac")
	private ACAS_ASR_PopulationCharacteristics popCharac;
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
	public ACAS_ASR_PopulationCharacteristics getPopCharac() {
		return popCharac;
	}
	public void setPopCharac(ACAS_ASR_PopulationCharacteristics popCharac) {
		this.popCharac = popCharac;
	}
}

