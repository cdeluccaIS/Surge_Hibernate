package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_cpeRecordDAO {
	
	public void addACAS_ARF_cpeRecord(ACAS_ARF_cpeRecord bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_cpeRecord(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_cpeRecord(Session session, ACAS_ARF_cpeRecord bean) {
		ACAS_ARF_cpeRecord acas_arf_cperecord = new ACAS_ARF_cpeRecord();

		acas_arf_cperecord.setUuid(bean.getUuid());
		acas_arf_cperecord.setPlatformName(bean.getPlatformName());
		
		session.save(acas_arf_cperecord);
	}
	
	public List<ACAS_ARF_cpeRecord> getACAS_ARF_cpeRecord(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_cperecord");
		List<ACAS_ARF_cpeRecord> acas_arf_cperecord = query.list();
		session.close();
		return acas_arf_cperecord;
	}
	
	public ACAS_ARF_cpeRecord updateACAS_ARF_cpeRecord(ACAS_ARF_cpeRecord acas_arf_cperecord) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_cperecord set platformname = :name"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_cperecord.getUuid());
		query.setParameter("name", acas_arf_cperecord.getPlatformName());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_cpeRecord(acas_arf_cperecord);
		}
		tx.commit();
		session.close();
		return acas_arf_cperecord;
		
	}
	
	public int deleteACAS_ARF_cpeRecord(ACAS_ARF_cpeRecord acas_arf_cperecord) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_cperecord where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_cperecord.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}