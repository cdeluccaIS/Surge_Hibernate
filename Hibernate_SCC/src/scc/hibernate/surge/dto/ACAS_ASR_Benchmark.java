package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_Benchmark")
public class ACAS_ASR_Benchmark{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="benchmarkID")
	private UUID benchmarkID;
	@Column (name="ruleResults")
	private UUID ruleResults;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getBenchmarkID() {
		return benchmarkID;
	}
	public void setBenchmarkID(UUID benchmarkID) {
		this.benchmarkID = benchmarkID;
	}
	public UUID getRuleResults() {
		return ruleResults;
	}
	public void setRuleResults(UUID ruleResults) {
		this.ruleResults = ruleResults;
	}
}
