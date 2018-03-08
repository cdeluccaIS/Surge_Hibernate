package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_Message")
public class ACAS_ASR_Message{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="prodRef")
	private UUID prodRef;
	@Column (name="resultPack")
	private UUID resultPack;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getProdRef() {
		return prodRef;
	}
	public void setProdRef(UUID prodRef) {
		this.prodRef = prodRef;
	}
	public UUID getResultPack() {
		return resultPack;
	}
	public void setResultPack(UUID resultPack) {
		this.resultPack = resultPack;
	}
}
