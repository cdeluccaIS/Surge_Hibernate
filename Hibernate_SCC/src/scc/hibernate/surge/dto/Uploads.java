package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name="Uploads")
public class Uploads {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="fileLocation")
	private String fileLocation;
	@Temporal (TemporalType.DATE)
	@Column (name="date")
	private Date date;
	@Column (name="type")
	private String type;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="state")	
	private State state;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="authority")
	private AccountDetails authority;
	@Column (name="status")
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name="timestamp", columnDefinition="BIGINT")
	private Date timestamp;
	
	public Uploads(){
	}
	public Uploads(String fileLoc, Date date, String type, State state, AccountDetails authority, String status,Timestamp timestamp){
		this.fileLocation = fileLoc;
		this.date = date;
		this.type = type;
		this.state = state;
		this.authority = authority;
		this.status = status;
		this.timestamp = timestamp;
	}
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
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public AccountDetails getAuthority() {
		return authority;
	}
	public void setAuthority(AccountDetails authority) {
		this.authority = authority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
