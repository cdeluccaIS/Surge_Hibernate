package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_ARDAO {
	
	public void addAcasARFar(ACAS_ARF_AR bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAcasARFar(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAcasARFar(Session session, ACAS_ARF_AR bean) {
		ACAS_ARF_AR acas_arf_ar = new ACAS_ARF_AR();

		acas_arf_ar.setUuid(bean.getUuid());
		acas_arf_ar.setXmlns_ar(bean.getXmlns_ar());
		acas_arf_ar.setXmlns_device(bean.getXmlns_device());
		acas_arf_ar.setXmlns_cpe(bean.getXmlns_cpe());
		acas_arf_ar.setXmlns_tagValue(bean.getXmlns_tagValue());
		acas_arf_ar.setXmlns_cndc(bean.getXmlns_cndc());
		
		session.save(acas_arf_ar);
	}
	
	public List<ACAS_ARF_AR> getAcasARFar(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_ar");
		List<ACAS_ARF_AR> acasARFar = query.list();
		session.close();
		return acasARFar;
	}
	
	public ACAS_ARF_AR updateAcasARFar(ACAS_ARF_AR acas_arf_ar) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_ar set xmlns_ar = :ar, xmlns_device = :device, xmlns_cpe = :cpe, xmlns_tagvalue = :tagvalue, xmlns_cndc = :cndc"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_ar.getUuid());
		query.setString("ar", acas_arf_ar.getXmlns_ar());
		query.setString("device",acas_arf_ar.getXmlns_device());
		query.setString("cpe", acas_arf_ar.getXmlns_cpe());
		query.setString("tagvalue", acas_arf_ar.getXmlns_tagValue());
		query.setString("cndc", acas_arf_ar.getXmlns_cndc());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAcasARFar(acas_arf_ar);
		}
		tx.commit();
		session.close();
		return acas_arf_ar;
		
	}
	
	public int deleteAcasARFar(ACAS_ARF_AR acas_arf_ar) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_ar where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_ar.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}