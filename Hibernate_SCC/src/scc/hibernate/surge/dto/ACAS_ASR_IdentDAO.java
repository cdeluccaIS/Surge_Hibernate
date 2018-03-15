package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_IdentDAO {
	
	public void addACAS_ASR_Ident(ACAS_ASR_Ident bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_Ident(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_Ident(Session session, ACAS_ASR_Ident bean) {
		ACAS_ASR_Ident object = new ACAS_ASR_Ident();

		object.setUuid(bean.getUuid());
		object.setData(bean.getData());
		
		session.save(object);
	}
	
	public List<ACAS_ASR_Ident> getACAS_ASR_Ident(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_ident");
		List<ACAS_ASR_Ident> object = query.list();
		session.close();
		return object;
	}
	
	public ACAS_ASR_Ident updateACAS_ASR_Ident(ACAS_ASR_Ident object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_ident set data = :data"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setParameter("data", object.getData());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_Ident(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ASR_Ident(ACAS_ASR_Ident object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_ident where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}