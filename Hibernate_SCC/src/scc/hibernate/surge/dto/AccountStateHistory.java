package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="AccountStateHistory")
public class AccountStateHistory {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="account")
	private UUID account;
	@Column (name="admin")
	private UUID admin;
	@Column (name="status")
	private String status;
	@Column (name="date")
	private Date date;
	@Column (name="justification")
	private String justification;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getAccount() {
		return account;
	}
	public void setAccount(UUID account) {
		this.account = account;
	}
	public UUID getAdmin() {
		return admin;
	}
	public void setAdmin(UUID admin) {
		this.admin = admin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	
}
