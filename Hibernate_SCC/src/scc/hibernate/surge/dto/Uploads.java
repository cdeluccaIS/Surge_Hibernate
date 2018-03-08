package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Uploads")
public class Uploads {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="fileLocation")
	private String fileLocation;
	@Column (name="date")
	private Date date;
	@Column (name="type")
	private String type;
	@Column (name="state")
	private UUID state;
	@Column (name="authority")
	private UUID authority;
	@Column (name="status")
	private String status;
	@Column (name="timestamp", columnDefinition="BIGINT")
	private long timestamp;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UUID getState() {
		return state;
	}
	public void setState(UUID state) {
		this.state = state;
	}
	public UUID getAuthority() {
		return authority;
	}
	public void setAuthority(UUID authority) {
		this.authority = authority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
