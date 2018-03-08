package scc.hibernate.surge.dto;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACAS_ASR_Result")
public class ACAS_ASR_Result{
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="count")
	private int count;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
