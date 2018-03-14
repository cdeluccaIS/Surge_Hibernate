package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_TaggedDAO {
	
	public void addACAS_ARF_Tagged(ACAS_ARF_Tagged bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_Tagged(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_Tagged(Session session, ACAS_ARF_Tagged bean) {
		ACAS_ARF_Tagged acas_arf_tagged = new ACAS_ARF_Tagged();

		acas_arf_tagged.setUuid(bean.getUuid());
		acas_arf_tagged.setName(bean.getName());
		acas_arf_tagged.setValue(bean.getValue());
		
		session.save(acas_arf_tagged);
	}
	
	public List<ACAS_ARF_Tagged> getACAS_ARF_Tagged(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_tagged");
		List<ACAS_ARF_Tagged> acas_arf_tagged = query.list();
		session.close();
		return acas_arf_tagged;
	}
	
	public ACAS_ARF_Tagged updateACAS_ARF_Tagged(ACAS_ARF_Tagged acas_arf_tagged) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_tagged set name = :name, value = :value"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_tagged.getUuid());
		query.setString("name", acas_arf_tagged.getName());
		query.setString("value",acas_arf_tagged.getValue());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_Tagged(acas_arf_tagged);
		}
		tx.commit();
		session.close();
		return acas_arf_tagged;
		
	}
	
	public int deleteACAS_ARF_Tagged(ACAS_ARF_Tagged acas_arf_tagged) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_tagged where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_tagged.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}