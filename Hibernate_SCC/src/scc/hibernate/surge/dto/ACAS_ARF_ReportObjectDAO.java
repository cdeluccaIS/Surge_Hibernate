package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_ReportObjectDAO {
	
	public void addAcasARFReportObject(ACAS_ARF_ReportObject bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAcasARFReportObject(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAcasARFReportObject(Session session, ACAS_ARF_ReportObject bean) {
		ACAS_ARF_ReportObject acasReportObject = new ACAS_ARF_ReportObject();

		acasReportObject.setUuid(bean.getUuid());
		acasReportObject.setDevice(bean.getDevice());
		
		session.save(acasReportObject);
	}
	
	public List<ACAS_ARF_ReportObject> getAcasMeta(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_reportobject");
		List<ACAS_ARF_ReportObject> acasReportObject = query.list();
		session.close();
		return acasReportObject;
	}
	
	public ACAS_ARF_ReportObject updateAcasARFReportObject(ACAS_ARF_ReportObject acasReportObject) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_reportobject set device = :device"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acasReportObject.getUuid());
		query.setParameter("device", acasReportObject.getDevice());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAcasARFReportObject(acasReportObject);
		}
		tx.commit();
		session.close();
		return acasReportObject;
		
	}
	
	public int deleteAcasARFReportObject(ACAS_ARF_ReportObject acasReportObject) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_reportobject where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acasReportObject.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}