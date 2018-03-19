package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_deviceIDDAO {
	
	public void addACAS_ARF_deviceID(ACAS_ARF_deviceID bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_deviceID(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_deviceID(Session session, ACAS_ARF_deviceID bean) {
		ACAS_ARF_deviceID acas_arf_deviceid = new ACAS_ARF_deviceID();

		acas_arf_deviceid.setUuid(bean.getUuid());
		acas_arf_deviceid.setResource(bean.getResource());
		acas_arf_deviceid.setRecord_id(bean.getRecord_id());
		
		session.save(acas_arf_deviceid);
	}
	
	public List<ACAS_ARF_deviceID> getACAS_ARF_deviceID(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_deviceid");
		List<ACAS_ARF_deviceID> acas_arf_deviceid = query.list();
		session.close();
		return acas_arf_deviceid;
	}
	
	public ACAS_ARF_deviceID updateACAS_ARF_deviceID(ACAS_ARF_deviceID acas_arf_deviceid) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_deviceid set resource = :resource, record_id = :record_id"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_deviceid.getUuid());
		query.setString("resource", acas_arf_deviceid.getResource());
		query.setString("record_id",acas_arf_deviceid.getRecord_id());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_deviceID(acas_arf_deviceid);
		}
		tx.commit();
		session.close();
		return acas_arf_deviceid;
		
	}
	
	public int deleteACAS_ARF_deviceID(ACAS_ARF_deviceID acas_arf_deviceid) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_deviceid where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_deviceid.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}