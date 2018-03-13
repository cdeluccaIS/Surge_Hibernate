package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_MessageDAO {
	
	public void addAcasARFMessage(ACAS_ARF_Message bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAcasARFMessage(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAcasARFMessage(Session session, ACAS_ARF_Message bean) {
		ACAS_ARF_Message acasMessage = new ACAS_ARF_Message();

		acasMessage.setUuid(bean.getUuid());
		acasMessage.setProdRef(bean.getProdRef());
		acasMessage.setAr(bean.getAr());
		
		session.save(acasMessage);
	}
	
	public List<ACAS_ARF_Message> getAcasMeta(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_message");
		List<ACAS_ARF_Message> acasMessage = query.list();
		session.close();
		return acasMessage;
	}
	
	public ACAS_ARF_Message updateAcasProdRef(ACAS_ARF_Message acas_message) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_message set prodref = :prodref, ar = :ar"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_message.getUuid());
		query.setParameter("prodref", acas_message.getProdRef());
		query.setParameter("ar",acas_message.getAr());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAcasARFMessage(acas_message);
		}
		tx.commit();
		session.close();
		return acas_message;
		
	}
	
	public int deleteAcasARFMessage(ACAS_ARF_Message acas_message) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_message where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_message.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}