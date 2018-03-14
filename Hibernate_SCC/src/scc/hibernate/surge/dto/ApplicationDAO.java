package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ApplicationDAO {
	
	public void addApplication(Application bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addApplication(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addApplication(Session session, Application bean) {
		Application app = new Application();

		app.setUuid(bean.getUuid());
		app.setTimeZone(bean.getTimeZone());
		app.setSysTime(bean.getSysTime());
		app.setVersion(bean.getVersion());
		app.setBuild(bean.getBuild());
		app.setReleaseDate(bean.getReleaseDate());
		app.setOs(bean.getOs());
		app.setNotice(bean.getNotice());
		app.setLdap_name(bean.getLdap_name());
		app.setLdap_URL(bean.getLdap_URL());
		app.setLdap_bindDN(bean.getLdap_bindDN());
		app.setLdap_bindPass(bean.getLdap_bindPass());
		app.setLdap_rootDN(bean.getLdap_rootDN());
		app.setLdap_port(bean.getLdap_port());
		
		session.save(app);
	}
	
	public List<Application> getApplication(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from application");
		List<Application> apps = query.list();
		session.close();
		return apps;
	}
	
	public Application updateApplication(Application app) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update application set timezone = :timezone, systime = :systime, version = :ver, build = :build, releasedate = :reldate, os = :os,"
				+ "notice = :notice, ldap_name = :name, ldap_url = :url, ldap_binddn = :binddn, ldap_bindpass = :pass, ldap_rootdn = :rootdn, ldap_port = :port"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", app.getUuid());
		query.setString("timezone", app.getTimeZone());
		query.setString("systime", app.getSysTime());
		query.setString("ver",app.getVersion());
		query.setString("build",app.getBuild());
		query.setDate("reldate",app.getReleaseDate());
		query.setString("os",app.getOs());
		query.setParameter("notice",app.getNotice());
		query.setString("name",app.getLdap_name());
		query.setString("url",app.getLdap_URL());
		query.setString("binddn",app.getLdap_bindDN());
		query.setString("pass",app.getLdap_bindPass());
		query.setString("rootdn",app.getLdap_rootDN());
		query.setString("port",app.getLdap_port());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addApplication(app);
		}
		tx.commit();
		session.close();
		return app;
		
	}
	
	public int deleteApplication(Application app) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from application where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", app.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}