package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_ID_FQDNDAO {
	
	public void addACAS_ARF_ID_FQDN(ACAS_ARF_ID_FQDN bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_ID_FQDN(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_ID_FQDN(Session session, ACAS_ARF_ID_FQDN bean) {
		ACAS_ARF_ID_FQDN acas_arf_id_fqdn = new ACAS_ARF_ID_FQDN();

		acas_arf_id_fqdn.setUuid(bean.getUuid());
		acas_arf_id_fqdn.setRealm(bean.getRealm());
		acas_arf_id_fqdn.setHostName(bean.getHostName());
		
		session.save(acas_arf_id_fqdn);
	}
	
	public List<ACAS_ARF_ID_FQDN> getACAS_ARF_ID_FQDN(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_id_fqdn");
		List<ACAS_ARF_ID_FQDN> acas_arf_id_fqdn = query.list();
		session.close();
		return acas_arf_id_fqdn;
	}
	
	public ACAS_ARF_ID_FQDN updateACAS_ARF_ID_FQDN(ACAS_ARF_ID_FQDN acas_arf_id_fqdn) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_id_fqdn set realm = :realm, hostname = :name"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_id_fqdn.getUuid());
		query.setString("realm", acas_arf_id_fqdn.getRealm());
		query.setString("name",acas_arf_id_fqdn.getHostName());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_ID_FQDN(acas_arf_id_fqdn);
		}
		tx.commit();
		session.close();
		return acas_arf_id_fqdn;
		
	}
	
	public int deleteACAS_ARF_ID_FQDN(ACAS_ARF_ID_FQDN acas_arf_id_fqdn) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_id_fqdn where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_id_fqdn.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}