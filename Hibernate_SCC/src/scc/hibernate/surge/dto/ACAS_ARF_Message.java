package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ARF_Message")
public class ACAS_ARF_Message {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="prodRef")
	private ACAS_ProdRef prodRef;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ar")
	private ACAS_ARF_AR ar;
	
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
	public ACAS_ARF_AR getAr() {
		return ar;
	}
	public void setAr(ACAS_ARF_AR ar) {
		this.ar = ar;
	}
	
}
