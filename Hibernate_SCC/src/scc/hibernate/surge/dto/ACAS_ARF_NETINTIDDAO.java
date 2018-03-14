package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_NETINTIDDAO {
	
	public void addACAS_ARF_NETINTID(ACAS_ARF_NETINTID bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_NETINTID(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_NETINTID(Session session, ACAS_ARF_NETINTID bean) {
		ACAS_ARF_NETINTID object = new ACAS_ARF_NETINTID();

		object.setUuid(bean.getUuid());
		object.setId(bean.getId());
		object.setHostData(bean.getHostData());
		
		session.save(object);
	}
	
	public List<ACAS_ARF_NETINTID> getACAS_ARF_NETINTID(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_netintid");
		List<ACAS_ARF_NETINTID> object = query.list();
		session.close();
		return object;
	}
	
	public ACAS_ARF_NETINTID updateACAS_ARF_NETINTID(ACAS_ARF_NETINTID object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_netintid set id = :id, hostdata = :hdata"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setParameter("id", object.getId());
		query.setParameter("hdata", object.getHostData());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_NETINTID(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ARF_NETINTID(ACAS_ARF_NETINTID object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_netintid where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}