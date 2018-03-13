package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_NETCONFIGDAO {
	
	public void addACAS_ARF_NETCONFIG( ACAS_ARF_NETCONFIG bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_NETCONFIG(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_NETCONFIG(Session session, ACAS_ARF_NETCONFIG bean) {
		ACAS_ARF_NETCONFIG acas_arf_netconfig = new ACAS_ARF_NETCONFIG();

		acas_arf_netconfig.setUuid(bean.getUuid());
		acas_arf_netconfig.setNetintid(bean.getNetintid());
		
		session.save(acas_arf_netconfig);
	}
	
	public List<ACAS_ARF_NETCONFIG> getACAS_ARF_NETCONFIG(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_netconfig");
		List<ACAS_ARF_NETCONFIG> acas_arf_netconfig = query.list();
		session.close();
		return acas_arf_netconfig;
	}
	
	public ACAS_ARF_NETCONFIG updateACAS_ARF_NETCONFIG( ACAS_ARF_NETCONFIG acas_arf_netconfig) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_netconfig set netintd = :netintid"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_netconfig.getUuid());
		query.setParameter("netintid", acas_arf_netconfig.getNetintid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_NETCONFIG(acas_arf_netconfig);
		}
		tx.commit();
		session.close();
		return acas_arf_netconfig;
		
	}
	
	public int deleteACAS_ARF_NETCONFIG( ACAS_ARF_NETCONFIG acas_arf_netconfig) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_netconfig where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_netconfig.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}