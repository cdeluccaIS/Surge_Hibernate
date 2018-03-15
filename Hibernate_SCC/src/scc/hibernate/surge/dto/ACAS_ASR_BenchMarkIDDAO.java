package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_BenchMarkIDDAO {
	
	public void addACAS_ASR_BenchMarkID(ACAS_ASR_BenchMarkID bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_BenchMarkID(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_BenchMarkID(Session session, ACAS_ASR_BenchMarkID bean) {
		ACAS_ASR_BenchMarkID object = new ACAS_ASR_BenchMarkID();

		object.setUuid(bean.getUuid());
		object.setResource(bean.getResource());
		object.setRecord_identifier(bean.getRecord_identifier());
		
		session.save(object);
	}
	
	public List<ACAS_ASR_BenchMarkID> getACAS_ASR_BenchMarkID(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_benchmarkid");
		List<ACAS_ASR_BenchMarkID> object = query.list();
		session.close();
		return object;
	}
	
	public ACAS_ASR_BenchMarkID updateACAS_ASR_BenchMarkID(ACAS_ASR_BenchMarkID object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_benchmarkid set resource = :resource, record_identifier = :rid"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setParameter("resource", object.getResource());
		query.setParameter("rid", object.getRecord_identifier());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_BenchMarkID(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ASR_BenchMarkID(ACAS_ASR_BenchMarkID object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_benchmarkid where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}