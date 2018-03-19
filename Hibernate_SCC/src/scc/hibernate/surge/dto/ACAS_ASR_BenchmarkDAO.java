package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_BenchmarkDAO {
	
	public void addACAS_ASR_Benchmark(ACAS_ASR_Benchmark bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_Benchmark(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_Benchmark(Session session, ACAS_ASR_Benchmark bean) {
		ACAS_ASR_Benchmark acas_asr_benchmark = new ACAS_ASR_Benchmark();

		acas_asr_benchmark.setUuid(bean.getUuid());
		acas_asr_benchmark.setBenchmarkID(bean.getBenchmarkID());
		acas_asr_benchmark.setRuleResults(bean.getRuleResults());
		
		session.save(acas_asr_benchmark);
	}
	
	public List<ACAS_ASR_Benchmark> getACAS_ASR_Benchmark(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_benchmark");
		List<ACAS_ASR_Benchmark> acas_asr_benchmark = query.list();
		session.close();
		return acas_asr_benchmark;
	}
	
	public ACAS_ASR_Benchmark updateACAS_ASR_Benchmark(ACAS_ASR_Benchmark object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_benchmark set benchmarkid = :bmkid, ruleresults = :res"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setParameter("bmkid", object.getBenchmarkID());
		query.setParameter("res", object.getRuleResults());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_Benchmark(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ASR_Benchmark(ACAS_ASR_Benchmark object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_benchmark where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}