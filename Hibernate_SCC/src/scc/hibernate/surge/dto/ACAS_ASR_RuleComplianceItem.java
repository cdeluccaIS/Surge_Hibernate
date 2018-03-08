package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_RuleComplianceItem")
public class ACAS_ASR_RuleComplianceItem{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="ruleResult")
	private String ruleResult;
	@Column (name="result")
	private UUID result;
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
	public UUID getResult() {
		return result;
	}
	public void setResult(UUID result) {
		this.result = result;
	}
}
