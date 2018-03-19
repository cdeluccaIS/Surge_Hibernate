package scc.hibernate.surge.dto;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

@Entity (name="TwistLock")
public class TwistLock {
	@Id
	@Column (name="uuid")
    private UUID uuid;
	@Column (name="registry", length=64)
    private String registry;
	@Column (name="repository", length=40)
    private char repository;
	@Column (name="tag", length=32)
    private String tag;
	@Column (name="dID", length=512)
    private String dID;
	@Column (name="distro", length=24)
    private String distro;
	@Column (name="hostname", length=48)
    private String hostname;
	@Column (name="running")
    private Boolean running;
	@Column (name="layer", length=24)
    private String layer;
	@Column (name="CVE", length=24)
    private String CVE;
	@Column (name="vID")
    private Integer vID;
	@Column (name="type", length=24)
    private String type;
	@Column (name="severity", length=24)
    private String severity;
	@Column (name="pName", length=48)
    private String pName;
	@Column (name="pVersion", length=24)
    private String pVersion;
	@Column (name="cvss")
    private Integer cvss;
	@Column (name="vendorStatus", length=24)
    private String vendorStatus;
	@Column (name="description", length=512)
    private String description;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getRegistry() {
		return registry;
	}
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	public char getRepository() {
		return repository;
	}
	public void setRepository(char repository) {
		this.repository = repository;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getdID() {
		return dID;
	}
	public void setdID(String dID) {
		this.dID = dID;
	}
	public String getDistro() {
		return distro;
	}
	public void setDistro(String distro) {
		this.distro = distro;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public Boolean getRunning() {
		return running;
	}
	public void setRunning(Boolean running) {
		this.running = running;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getCVE() {
		return CVE;
	}
	public void setCVE(String cVE) {
		CVE = cVE;
	}
	public Integer getvID() {
		return vID;
	}
	public void setvID(Integer vID) {
		this.vID = vID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpVersion() {
		return pVersion;
	}
	public void setpVersion(String pVersion) {
		this.pVersion = pVersion;
	}
	public Integer getCvss() {
		return cvss;
	}
	public void setCvss(Integer cvss) {
		this.cvss = cvss;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}