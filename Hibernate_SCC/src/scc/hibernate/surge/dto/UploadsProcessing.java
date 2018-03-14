package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="UploadsProcessing")
public class UploadsProcessing {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="document")
	private Document document;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="upload")
	private Uploads upload;
	@Column (name="pCompletion")
	private int pCompletion;
	@Column (name="state")
	private String state;
	
	public UploadsProcessing(){
	}
	public UploadsProcessing(Document document, Uploads upload, int pCompletion, String state){
		this.document = document;
		this.upload = upload;
		this.pCompletion = pCompletion;
		this.state = state;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Uploads getUpload() {
		return upload;
	}
	public void setUpload(Uploads upload) {
		this.upload = upload;
	}
	public int getpCompletion() {
		return pCompletion;
	}
	public void setpCompletion(int pCompletion) {
		this.pCompletion = pCompletion;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
