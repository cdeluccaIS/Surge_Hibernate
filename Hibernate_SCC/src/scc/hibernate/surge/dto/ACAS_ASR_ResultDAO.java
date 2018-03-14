package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_ResultDAO {
	
	public void addACAS_ASR_Result(ACAS_ASR_Result bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_Result(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_Result(Session session, ACAS_ASR_Result bean) {
		ACAS_ASR_Result object = new ACAS_ASR_Result();

		object.setUuid(bean.getUuid());
		object.setCount(bean.getCount());
		
		session.save(object);
	}
	
	public List<ACAS_ASR_Result> getACAS_ASR_Result(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_result");
		List<ACAS_ASR_Result> object = query.list();
		session.close();
		return object;
	}
	
	public ACAS_ASR_Result updateACAS_ASR_Result(ACAS_ASR_Result object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_result set count = :count"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setInteger("count", object.getCount());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_Result(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ASR_Result(ACAS_ASR_Result object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_result where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}