package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_HOSTDATADAO {
	
	public void addACAS_ARF_HOSTDATA(ACAS_ARF_HOSTDATA bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_HOSTDATA(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_HOSTDATA(Session session, ACAS_ARF_HOSTDATA bean) {
		ACAS_ARF_HOSTDATA acas_arf_hostdata = new ACAS_ARF_HOSTDATA();

		acas_arf_hostdata.setUuid(bean.getUuid());
		acas_arf_hostdata.setMacAddress(bean.getMacAddress());
		acas_arf_hostdata.setConnectionIP(bean.getConnectionIP());
		
		session.save(acas_arf_hostdata);
	}
	
	public List<ACAS_ARF_HOSTDATA> getACAS_ARF_HOSTDATA(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_hostdata");
		List<ACAS_ARF_HOSTDATA> acas_arf_hostdata = query.list();
		session.close();
		return acas_arf_hostdata;
	}
	
	public ACAS_ARF_HOSTDATA updateACAS_ARF_HOSTDATA(ACAS_ARF_HOSTDATA acas_arf_hostdata) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_hostdata set macaddress = :mac, connectionip = :ip"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_hostdata.getUuid());
		query.setString("mac", acas_arf_hostdata.getMacAddress());
		query.setParameter("ip",acas_arf_hostdata.getConnectionIP());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_HOSTDATA(acas_arf_hostdata);
		}
		tx.commit();
		session.close();
		return acas_arf_hostdata;
		
	}
	
	public int deleteACAS_ARF_HOSTDATA(ACAS_ARF_HOSTDATA acas_arf_hostdata) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_hostdata where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_hostdata.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}