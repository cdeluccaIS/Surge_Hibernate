package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_DeviceDAO {
	
	public void addAcasARFDevice(ACAS_ARF_Device bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAcasARFDevice(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAcasARFDevice(Session session, ACAS_ARF_Device bean) {
		ACAS_ARF_Device acas_arf_device = new ACAS_ARF_Device();

		acas_arf_device.setUuid(bean.getUuid());
		acas_arf_device.setDeviceID(bean.getDeviceID());
		acas_arf_device.setIdentifiers(bean.getIdentifiers());
		acas_arf_device.setOp_attr(bean.getOp_attr());
		acas_arf_device.setTimestamp(bean.getTimestamp());
		acas_arf_device.setTagged(bean.getTagged());
		
		session.save(acas_arf_device);
	}
	
	public List<ACAS_ARF_Device> getAcasARFDevice(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_device");
		List<ACAS_ARF_Device> acas_arf_device = query.list();
		session.close();
		return acas_arf_device;
	}
	
	public ACAS_ARF_Device updateAcasARFDevice(ACAS_ARF_Device acas_arf_device) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_device set deviceid = :deviceid, identifiers = :ident, op_attr = :op_attr, configuration = :config, timestamp = :timestamp, tagged = :tag"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_device.getUuid());
		query.setParameter("deviceid", acas_arf_device.getDeviceID());
		query.setParameter("ident",acas_arf_device.getIdentifiers());
		query.setParameter("op_attr",acas_arf_device.getOp_attr());
		query.setParameter("config",acas_arf_device.getConfiguration());
		query.setLong("timestamp",acas_arf_device.getTimestamp());
		query.setParameter("tag",acas_arf_device.getTagged());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAcasARFDevice(acas_arf_device);
		}
		tx.commit();
		session.close();
		return acas_arf_device;
		
	}
	
	public int deleteAcasARFDevice(ACAS_ARF_Device acas_arf_device) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_device where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_device.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}
