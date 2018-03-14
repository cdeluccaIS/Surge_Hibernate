package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_RuleResultDAO {
	
	public void addACAS_ASR_RuleResult(ACAS_ASR_RuleResult bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_RuleResult(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_RuleResult(Session session, ACAS_ASR_RuleResult bean) {
		ACAS_ASR_RuleResult object = new ACAS_ASR_RuleResult();

		object.setUuid(bean.getUuid());
		object.setRuleID(bean.getRuleID());
		object.setIdent(bean.getIdent());
		object.setRuleComplianceItem(bean.getRuleComplianceItem());
		
		session.save(object);
	}
	
	public List<ACAS_ASR_RuleResult> getAACAS_ASR_RuleResult(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_ruleresult");
		List<ACAS_ASR_RuleResult> object = query.list();
		session.close();
		return object;
	}
	
	public ACAS_ASR_RuleResult updateACAS_ASR_RuleResult(ACAS_ASR_RuleResult object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_ruleresult set ruleid = :ruleid, ident = :ident, rulecomplianceitem = :rcomp"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		query.setParameter("ruleid", object.getRuleID());
		query.setParameter("ident", object.getIdent());
		query.setParameter("rcomp", object.getRuleComplianceItem());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_RuleResult(object);
		}
		tx.commit();
		session.close();
		return object;
		
	}
	
	public int deleteACAS_ASR_RuleResult(ACAS_ASR_RuleResult object) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_ruleresult where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", object.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}