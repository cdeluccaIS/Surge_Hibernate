package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ApplicationNoticesDAO {
	
	public void addApplicationNotices(ApplicationNotices bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addApplicationNotices(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addApplicationNotices(Session session, ApplicationNotices bean) {
		ApplicationNotices object = new ApplicationNotices();

		object.setUuid(bean.getUuid());
		object.setName(bean.getName());
		object.setNotice(bean.getNotice());
		object.setDatetime(bean.getDatetime());
		
		session.save(object);
	}
	
	public List<ApplicationNotices> getApplicationNotices(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from applicationnotices");
		List<ApplicationNotices> object = query.list();
		session.close();
		return object;
	}
	
	public ApplicationNotices updateApplicationNotices(ApplicationNotices object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update applicationnotices set name = :name, notice = :notice, datetime = :datetime"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setString("name", object.getName());
		query.setString("notice", object.getNotice());
		query.setParameter("datetime", object.getDatetime());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addApplicationNotices(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteApplicationNotices(ApplicationNotices object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from applicationnotices where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}