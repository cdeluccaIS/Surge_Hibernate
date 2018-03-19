package scc.hibernate.surge.dto;

import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name="Application")
public class Application {
	@Id
	@Column (name="uuid")
    private UUID uuid;
	@Column (name="timeZone")
    private String timeZone;
	@Column (name="sysTime")
    private String sysTime;
	@Column (name="version")
    private String version;
	@Column (name="build")
    private String build;
    @Column (name="releaseDate")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column (name="os")
    private String os;
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="notice")
    private ApplicationNotices notice;	//UUID.fromString("00000000-0000-0000-0000-000000000000");
    @Column (name="ldap_name")
    private String ldap_name = "--";
    @Column (name="ldap_URL")
    private String ldap_URL = "--";
    @Column (name="ldap_bindDN")
    private String ldap_bindDN = "--";
    @Column (name="ldap_bindPass")
    private String ldap_bindPass = "--";
    @Column (name="ldap_rootDN")
    private String ldap_rootDN = "--";
    @Column (name="ldap_port")
    private String ldap_port = "--";
    
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getSysTime() {
		return sysTime;
	}
	public void setSysTime(String sysTime) {
		this.sysTime = sysTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public ApplicationNotices getNotice() {
		return notice;
	}
	public void setNotice(ApplicationNotices notice) {
		this.notice = notice;
	}
	public String getLdap_name() {
		return ldap_name;
	}
	public void setLdap_name(String ldap_name) {
		this.ldap_name = ldap_name;
	}
	public String getLdap_URL() {
		return ldap_URL;
	}
	public void setLdap_URL(String ldap_URL) {
		this.ldap_URL = ldap_URL;
	}
	public String getLdap_bindDN() {
		return ldap_bindDN;
	}
	public void setLdap_bindDN(String ldap_bindDN) {
		this.ldap_bindDN = ldap_bindDN;
	}
	public String getLdap_bindPass() {
		return ldap_bindPass;
	}
	public void setLdap_bindPass(String ldap_bindPass) {
		this.ldap_bindPass = ldap_bindPass;
	}
	public String getLdap_rootDN() {
		return ldap_rootDN;
	}
	public void setLdap_rootDN(String ldap_rootDN) {
		this.ldap_rootDN = ldap_rootDN;
	}
	public String getLdap_port() {
		return ldap_port;
	}
	public void setLdap_port(String ldap_port) {
		this.ldap_port = ldap_port;
	}
    
}
