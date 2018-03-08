package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="UploadsProcessing")
public class UploadsProcessing {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="document")
	private UUID document;
	@Column (name="upload")
	private UUID upload;
	@Column (name="pCompletion")
	private int pCompletion;
	@Column (name="state")
	private String state;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getDocument() {
		return document;
	}
	public void setDocument(UUID document) {
		this.document = document;
	}
	public UUID getUpload() {
		return upload;
	}
	public void setUpload(UUID upload) {
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
