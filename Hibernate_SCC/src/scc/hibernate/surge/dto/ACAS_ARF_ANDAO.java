package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_ANDAO {
	
	public void addACAS_ARF_AN(ACAS_ARF_AN bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_AN(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_AN(Session session, ACAS_ARF_AN bean) {
		ACAS_ARF_AN acas_arf_an = new ACAS_ARF_AN();

		acas_arf_an.setUuid(bean.getUuid());
		acas_arf_an.setName(bean.getName());
		
		session.save(acas_arf_an);
	}
	
	public List<ACAS_ARF_AN> getACAS_ARF_AN(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_an");
		List<ACAS_ARF_AN> acas_arf_an = query.list();
		session.close();
		return acas_arf_an;
	}
	
	public ACAS_ARF_AN updateACAS_ARF_AN(ACAS_ARF_AN acas_arf_an) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_an set name = :name"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_an.getUuid());
		query.setParameter("name", acas_arf_an.getName());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_AN(acas_arf_an);
		}
		tx.commit();
		session.close();
		return acas_arf_an;
		
	}
	
	public int deleteACAS_ARF_AN(ACAS_ARF_AN acas_arf_an) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_an where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_an.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}