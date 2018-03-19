package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_OPATTRDAO {
	
	public void addACAS_ARF_OPATTR(ACAS_ARF_OPATTR bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_OPATTR(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_OPATTR(Session session, ACAS_ARF_OPATTR bean) {
		ACAS_ARF_OPATTR acas_arf_opattr = new ACAS_ARF_OPATTR();

		acas_arf_opattr.setUuid(bean.getUuid());
		acas_arf_opattr.setResource(bean.getResource());
		acas_arf_opattr.setRecordID(bean.getRecordID());
		
		session.save(acas_arf_opattr);
	}
	
	public List<ACAS_ARF_OPATTR> getACAS_ARF_OPATTR(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_opattr");
		List<ACAS_ARF_OPATTR> acas_arf_opattr = query.list();
		session.close();
		return acas_arf_opattr;
	}
	
	public ACAS_ARF_OPATTR updateACAS_ARF_OPATTR(ACAS_ARF_OPATTR acas_arf_opattr) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_opattr set resource = :resource, recordid = :record_id"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_opattr.getUuid());
		query.setString("resource", acas_arf_opattr.getResource());
		query.setString("record_id",acas_arf_opattr.getRecordID());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_OPATTR(acas_arf_opattr);
		}
		tx.commit();
		session.close();
		return acas_arf_opattr;
		
	}
	
	public int deleteACAS_ARF_OPATTR(ACAS_ARF_OPATTR acas_arf_opattr) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_opattr where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_opattr.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}