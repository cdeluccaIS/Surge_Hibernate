package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ApplicationNotices")
public class ApplicationNotices {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="name")
	private String name;
	@Column (name="notice")
	private String notice ;
	@Column (name="datetime")
	private Date datetime;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}