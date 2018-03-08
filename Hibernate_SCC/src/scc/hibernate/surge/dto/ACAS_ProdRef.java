package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ProdRef")
public class ACAS_ProdRef {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="topic")
	private String topic;
	@Column (name="topic_dialect")
	private String topic_dialect;
	@Column (name="address")
	private String address;
	@Column (name="meta")
	private UUID meta;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTopic_dialect() {
		return topic_dialect;
	}
	public void setTopic_dialect(String topic_dialect) {
		this.topic_dialect = topic_dialect;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UUID getMeta() {
		return meta;
	}
	public void setMeta(UUID meta) {
		this.meta = meta;
	}
	
}