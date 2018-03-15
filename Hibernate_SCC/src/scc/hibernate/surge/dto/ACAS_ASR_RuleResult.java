package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ASR_RuleResult")
public class ACAS_ASR_RuleResult{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="ruleID")
	private String ruleID;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ident")
	private ACAS_ASR_Ident ident;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ruleComplianceItem")
	private ACAS_ASR_RuleComplianceItem ruleComplianceItem;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getRuleID() {
		return ruleID;
	}
	public void setRuleID(String ruleID) {
		this.ruleID = ruleID;
	}
	public ACAS_ASR_Ident getIdent() {
		return ident;
	}
	public void setIdent(ACAS_ASR_Ident ident) {
		this.ident = ident;
	}
	public ACAS_ASR_RuleComplianceItem getRuleComplianceItem() {
		return ruleComplianceItem;
	}
	public void setRuleComplianceItem(ACAS_ASR_RuleComplianceItem ruleComplianceItem) {
		this.ruleComplianceItem = ruleComplianceItem;
	}
}
