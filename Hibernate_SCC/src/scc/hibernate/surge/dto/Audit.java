package scc.hibernate.surge.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name="Audit")
public class Audit {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="event")
	private String event = "--";
	@Column (name="eventType")
	private String eventType = "---";
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_account")
	private AccountDetails user_uuid;
	
	public Audit(){	
	}
	public Audit(String event, String eventType, AccountDetails user_uuid){
		this.event = event;
		this.eventType = eventType;
		this.user_uuid = user_uuid;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public AccountDetails getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(AccountDetails user_uuid) {
		this.user_uuid = user_uuid;
	}

	
}
