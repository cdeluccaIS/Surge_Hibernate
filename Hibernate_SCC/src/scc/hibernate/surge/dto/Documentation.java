package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Documentation")
public class Documentation {
	@Id
	@Column (name="uuid")
	private UUID uuid;
	@Column (name="xmlTemplate")
	private String xmlTemplate;
	@Column (name="xlsTemplate")
	private String xlsTemplate;
	@Column (name="jsonTemplate")
	private String jsonTemplate;
	@Column (name="instructions")
	private String instructions;
	@Column (name="apilmpDoc")
	private String apilmpDoc;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getXmlTemplate() {
		return xmlTemplate;
	}
	public void setXmlTemplate(String xmlTemplate) {
		this.xmlTemplate = xmlTemplate;
	}
	public String getXlsTemplate() {
		return xlsTemplate;
	}
	public void setXlsTemplate(String xlsTemplate) {
		this.xlsTemplate = xlsTemplate;
	}
	public String getJsonTemplate() {
		return jsonTemplate;
	}
	public void setJsonTemplate(String jsonTemplate) {
		this.jsonTemplate = jsonTemplate;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getApilmpDoc() {
		return apilmpDoc;
	}
	public void setApilmpDoc(String apilmpDoc) {
		this.apilmpDoc = apilmpDoc;
	}
	
}