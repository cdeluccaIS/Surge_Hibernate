package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_IdentifierDAO {
	
	public void addACAS_ARF_Identifier(ACAS_ARF_Identifier bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_Identifier(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_Identifier(Session session, ACAS_ARF_Identifier bean) {
		ACAS_ARF_Identifier acas_arf_identifier = new ACAS_ARF_Identifier();

		acas_arf_identifier.setUuid(bean.getUuid());
		acas_arf_identifier.setFqdn(bean.getFqdn());
		
		session.save(acas_arf_identifier);
	}
	
	public List<ACAS_ARF_Identifier> getACAS_ARF_Identifier(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_identifier");
		List<ACAS_ARF_Identifier> acas_arf_identifier = query.list();
		session.close();
		return acas_arf_identifier;
	}
	
	public ACAS_ARF_Identifier updateACAS_ARF_Identifier(ACAS_ARF_Identifier acas_arf_identifier) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_identifier set fqdn = :fqdn"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_identifier.getUuid());
		query.setParameter("fqdn", acas_arf_identifier.getFqdn());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_Identifier(acas_arf_identifier);
		}
		tx.commit();
		session.close();
		return acas_arf_identifier;
		
	}
	
	public int deleteACAS_ARF_Identifier(ACAS_ARF_Identifier acas_arf_identifier) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_identifier where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_identifier.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}