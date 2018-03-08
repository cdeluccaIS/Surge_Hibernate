package scc.hibernate.surge.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Audit")
public class Audit {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="event")
	private String event = "--";
	@Column (name="eventType")
	private String eventType = "---";
	@Column (name="user_uuid")
	private UUID user_uuid;
	
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
	public UUID getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(UUID user_uuid) {
		this.user_uuid = user_uuid;
	}

	
}
