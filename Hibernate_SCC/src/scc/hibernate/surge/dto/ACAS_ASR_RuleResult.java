package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_RuleResult")
public class ACAS_ASR_RuleResult{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="ruleID")
	private String ruleID;
	@Column (name="ident")
	private UUID ident;
	@Column (name="ruleComplianceItem")
	private UUID ruleComplianceItem;
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
	public UUID getIdent() {
		return ident;
	}
	public void setIdent(UUID ident) {
		this.ident = ident;
	}
	public UUID getRuleComplianceItem() {
		return ruleComplianceItem;
	}
	public void setRuleComplianceItem(UUID ruleComplianceItem) {
		this.ruleComplianceItem = ruleComplianceItem;
	}
}
