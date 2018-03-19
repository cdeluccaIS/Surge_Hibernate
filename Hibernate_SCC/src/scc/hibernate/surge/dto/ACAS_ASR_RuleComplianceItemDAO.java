package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_RuleComplianceItemDAO {
	
	public void addACAS_ASR_RuleComplianceItem(ACAS_ASR_RuleComplianceItem bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_RuleComplianceItem(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_RuleComplianceItem(Session session, ACAS_ASR_RuleComplianceItem bean) {
		ACAS_ASR_RuleComplianceItem object = new ACAS_ASR_RuleComplianceItem();

		object.setUuid(bean.getUuid());
		object.setRuleResult(bean.getRuleResult());
		object.setResult(bean.getResult());
		
		session.save(object);
	}
	
	public List<ACAS_ASR_RuleComplianceItem> getACAS_ASR_RuleComplianceItem(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_rulecomplianceitem");
		List<ACAS_ASR_RuleComplianceItem> object = query.list();
		session.close();
		return object;
	}
	
	public ACAS_ASR_RuleComplianceItem updateACAS_ASR_RuleComplianceItem(ACAS_ASR_RuleComplianceItem object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_rulecomplianceitem set ruleresult = :rule, result = :result"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setString("rule", object.getRuleResult());
		query.setParameter("result", object.getResult());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_RuleComplianceItem(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ASR_RuleComplianceItem(ACAS_ASR_RuleComplianceItem object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_rulecomplianceitem where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}