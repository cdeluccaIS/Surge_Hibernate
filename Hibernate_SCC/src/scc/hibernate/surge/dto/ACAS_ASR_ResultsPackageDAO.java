package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_ResultsPackageDAO {
	
	public void addACAS_ASR_ResultsPackage(ACAS_ASR_ResultsPackage bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_ResultsPackage(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_ResultsPackage(Session session, ACAS_ASR_ResultsPackage bean) {
		ACAS_ASR_ResultsPackage acas_asr_resultspackage = new ACAS_ASR_ResultsPackage();

		acas_asr_resultspackage.setUuid(bean.getUuid());
		acas_asr_resultspackage.setCndc(bean.getCndc());
		acas_asr_resultspackage.setSummRes(bean.getSummRes());
		acas_asr_resultspackage.setPopCharac(bean.getPopCharac());
		
		session.save(acas_asr_resultspackage);
	}
	
	public List<ACAS_ASR_ResultsPackage> getACAS_ASR_ResultsPackage(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_resultspackage");
		List<ACAS_ASR_ResultsPackage> acas_asr_resultspackage = query.list();
		session.close();
		return acas_asr_resultspackage;
	}
	
	public ACAS_ASR_ResultsPackage updateACAS_ASR_ResultsPackage(ACAS_ASR_ResultsPackage acas_asr_resultspackage) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_resultspackage set cndc = :cndc, summres = :summ, popcharac = :pop"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_asr_resultspackage.getUuid());
		query.setString("cndc", acas_asr_resultspackage.getCndc());
		query.setString("summ", acas_asr_resultspackage.getSummRes());
		query.setParameter("pop", acas_asr_resultspackage.getPopCharac());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_ResultsPackage(acas_asr_resultspackage);
		}
		tx.commit();
		session.close();
		return acas_asr_resultspackage;
		
	}
	
	public int deleteACAS_ASR_ResultsPackage(ACAS_ASR_ResultsPackage acas_asr_resultspackage) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_resultspackage where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_asr_resultspackage.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}