package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ASR_RuleComplianceItem")
public class ACAS_ASR_RuleComplianceItem{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="ruleResult")
	private String ruleResult;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="result")
	private ACAS_ASR_Result result;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getRuleResult() {
		return ruleResult;
	}
	public void setRuleResult(String ruleResult) {
		this.ruleResult = ruleResult;
	}
	public ACAS_ASR_Result getResult() {
		return result;
	}
	public void setResult(ACAS_ASR_Result result) {
		this.result = result;
	}
}

