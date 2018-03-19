package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name="ACAS_ASR_Benchmark")
public class ACAS_ASR_Benchmark{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="benchmarkID")
	private ACAS_ASR_BenchMarkID benchmarkID;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ruleResults")
	private ACAS_ASR_RuleResult ruleResults;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public ACAS_ASR_BenchMarkID getBenchmarkID() {
		return benchmarkID;
	}
	public void setBenchmarkID(ACAS_ASR_BenchMarkID benchmarkID) {
		this.benchmarkID = benchmarkID;
	}
	public ACAS_ASR_RuleResult getRuleResults() {
		return ruleResults;
	}
	public void setRuleResults(ACAS_ASR_RuleResult ruleResults) {
		this.ruleResults = ruleResults;
	}
}
