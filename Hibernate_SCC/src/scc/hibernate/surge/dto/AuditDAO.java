package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class AuditDAO {
	
	public void addAudit(Audit bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAudit(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAudit(Session session, Audit bean) {
		Audit audit = new Audit();

		audit.setUuid(bean.getUuid());
		audit.setEvent(bean.getEvent());
		audit.setEventType(bean.getEventType());
		audit.setUser_uuid(bean.getUser_uuid());
		
		session.save(audit);
	}
	
	public List<Audit> getAudit(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from audit");
		List<Audit> audits = query.list();
		session.close();
		return audits;
	}
	
	public Audit updateAudit(Audit audit) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update audit set event = :event, eventtype = :eventtype, user_uuid = :user_uuid"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", audit.getUuid());
		query.setString("event", audit.getEvent());
		query.setString("eventtype",audit.getEventType());
		query.setParameter("user_uuid",audit.getUser_uuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAudit(audit);
		}
		tx.commit();
		session.close();
		return audit;
		
	}
	
	public int deleteAudit(Audit audit) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from audit where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", audit.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}