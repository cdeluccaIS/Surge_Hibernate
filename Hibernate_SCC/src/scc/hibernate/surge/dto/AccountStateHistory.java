package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name="AccountStateHistory")
public class AccountStateHistory {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="account")
	private AccountDetails account;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="admin")
	private AccountDetails admin;
	@Column (name="status")
	private String status;
	@Temporal (TemporalType.DATE)
	@Column (name="date")
	private Date date;
	@Column (name="justification")
	private String justification;
	
	public AccountStateHistory(){
		
	}
	public AccountStateHistory(AccountDetails account, AccountDetails admin, 
			String status, Date date, String justification){
		this.account = account;
		this.admin = admin;
		this.status = status;
		this.date = date;
		this.justification = justification;
				
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public AccountDetails getAccount() {
		return account;
	}
	public void setAccount(AccountDetails account) {
		this.account = account;
	}
	public AccountDetails getAdmin() {
		return admin;
	}
	public void setAdmin(AccountDetails admin) {
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
