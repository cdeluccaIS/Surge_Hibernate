package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_PopulationCharacteristicsDAO {
	
	public void addACAS_ASR_PopulationCharacteristics(ACAS_ASR_PopulationCharacteristics bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_PopulationCharacteristics(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_PopulationCharacteristics(Session session, ACAS_ASR_PopulationCharacteristics bean) {
		ACAS_ASR_PopulationCharacteristics acas_asr_populationcharacteristics = new ACAS_ASR_PopulationCharacteristics();

		acas_asr_populationcharacteristics.setUuid(bean.getUuid());
		acas_asr_populationcharacteristics.setResource(bean.getResource());
		
		session.save(acas_asr_populationcharacteristics);
	}
	
	public List<ACAS_ASR_PopulationCharacteristics> getACAS_ASR_PopulationCharacteristics(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_populationcharacteristics");
		List<ACAS_ASR_PopulationCharacteristics> acas_asr_populationcharacteristics = query.list();
		session.close();
		return acas_asr_populationcharacteristics;
	}
	
	public ACAS_ASR_PopulationCharacteristics updateACAS_ASR_PopulationCharacteristics(ACAS_ASR_PopulationCharacteristics acas_asr_populationcharacteristics) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_populationcharacteristics set resource = :resource"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_asr_populationcharacteristics.getUuid());
		query.setString("resource", acas_asr_populationcharacteristics.getResource());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_PopulationCharacteristics(acas_asr_populationcharacteristics);
		}
		tx.commit();
		session.close();
		return acas_asr_populationcharacteristics;
		
	}
	
	public int deleteACAS_ASR_PopulationCharacteristics(ACAS_ASR_PopulationCharacteristics acas_asr_populationcharacteristics) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_populationcharacteristics where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_asr_populationcharacteristics.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}