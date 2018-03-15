package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_PlatformNameDAO {
	
	public void addACAS_ARF_PlatformName(ACAS_ARF_PlatformName bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_PlatformName(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_PlatformName(Session session, ACAS_ARF_PlatformName bean) {
		ACAS_ARF_PlatformName acas_arf_platformname = new ACAS_ARF_PlatformName();

		acas_arf_platformname.setUuid(bean.getUuid());
		acas_arf_platformname.setAssessedname(bean.getAssessedname());
		
		session.save(acas_arf_platformname);
	}
	
	public List<ACAS_ARF_PlatformName> getACAS_ARF_PlatformName(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_platformname");
		List<ACAS_ARF_PlatformName> acas_arf_platformname = query.list();
		session.close();
		return acas_arf_platformname;
	}
	
	public ACAS_ARF_PlatformName updateACAS_ARF_PlatformName(ACAS_ARF_PlatformName acas_arf_platformname) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_platformname set assessedname = :name"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_platformname.getUuid());
		query.setParameter("name", acas_arf_platformname.getAssessedname());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_PlatformName(acas_arf_platformname);
		}
		tx.commit();
		session.close();
		return acas_arf_platformname;
		
	}
	
	public int deleteACAS_ARF_PlatformName(ACAS_ARF_PlatformName acas_arf_platformname) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_platformname where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_platformname.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}