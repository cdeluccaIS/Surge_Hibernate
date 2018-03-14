package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ASR_MessageDAO {
	
	public void addACAS_ASR_Message(ACAS_ASR_Message bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ASR_Message(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ASR_Message(Session session, ACAS_ASR_Message bean) {
		ACAS_ASR_Message acas_asr_message = new ACAS_ASR_Message();

		acas_asr_message.setUuid(bean.getUuid());
		acas_asr_message.setProdRef(bean.getProdRef());
		acas_asr_message.setResultPack(bean.getResultPack());
		
		session.save(acas_asr_message);
	}
	
	public List<ACAS_ASR_Message> getACAS_ASR_Message(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_asr_message");
		List<ACAS_ASR_Message> acas_asr_message = query.list();
		session.close();
		return acas_asr_message;
	}
	
	public ACAS_ASR_Message updateACAS_ASR_Message(ACAS_ASR_Message acas_asr_message) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_asr_message set prodref = :prodref, resultpack = :pack"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_asr_message.getUuid());
		query.setParameter("prodref", acas_asr_message.getProdRef());
		query.setParameter("pack", acas_asr_message.getResultPack());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ASR_Message(acas_asr_message);
		}
		tx.commit();
		session.close();
		return acas_asr_message;
		
	}
	
	public int deleteACAS_ASR_Message(ACAS_ASR_Message acas_asr_message) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_asr_message where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_asr_message.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}