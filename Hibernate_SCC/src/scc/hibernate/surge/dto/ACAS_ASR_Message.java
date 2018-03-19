package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ASR_Message")
public class ACAS_ASR_Message{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="prodRef")
	private ACAS_ProdRef prodRef;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="resultPack")
	private ACAS_ASR_ResultsPackage resultPack;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ProdRef getProdRef() {
		return prodRef;
	}
	public void setProdRef(ACAS_ProdRef prodRef) {
		this.prodRef = prodRef;
	}
	public ACAS_ASR_ResultsPackage getResultPack() {
		return resultPack;
	}
	public void setResultPack(ACAS_ASR_ResultsPackage resultPack) {
		this.resultPack = resultPack;
	}
}
