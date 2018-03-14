package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ProdRefDAO {
	
	public void addAcasProdRef(ACAS_ProdRef bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAcasProdRef(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAcasProdRef(Session session, ACAS_ProdRef bean) {
		ACAS_ProdRef acasProdRef = new ACAS_ProdRef();

		acasProdRef.setUuid(bean.getUuid());
		acasProdRef.setTopic(bean.getTopic());
		acasProdRef.setTopic_dialect(bean.getTopic_dialect());
		acasProdRef.setAddress(bean.getAddress());
		acasProdRef.setMeta(bean.getMeta());
		
		session.save(acasProdRef);
	}
	
	public List<ACAS_ProdRef> getAcasProdRef(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_prodref");
		List<ACAS_ProdRef> acasProdRef = query.list();
		session.close();
		return acasProdRef;
	}
	
	public ACAS_ProdRef updateAcasProdRef(ACAS_ProdRef acasProdRef) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_prodref set topic = :topic, topic_dialect = :topic_dialect, address = :address, meta = :meta"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acasProdRef.getUuid());
		query.setString("topic", acasProdRef.getTopic());
		query.setString("topic_dialect",acasProdRef.getTopic_dialect());
		query.setString("address", acasProdRef.getAddress());
		query.setParameter("meta", acasProdRef.getMeta());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAcasProdRef(acasProdRef);
		}
		tx.commit();
		session.close();
		return acasProdRef;
		
	}
	
	public int deleteAcasProdRef(ACAS_ProdRef acasProdRef) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_prodref where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid",  acasProdRef.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}