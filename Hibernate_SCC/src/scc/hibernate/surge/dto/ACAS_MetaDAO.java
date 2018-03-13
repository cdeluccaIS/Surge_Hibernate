package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_MetaDAO {
	
	public void addAcasMeta(ACAS_Meta bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAcasMeta(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAcasMeta(Session session, ACAS_Meta bean) {
		ACAS_Meta acasMeta = new ACAS_Meta();

		acasMeta.setUuid(bean.getUuid());
		acasMeta.setMessageID(bean.getMessageID());
		acasMeta.setTagValue(bean.getTagValue());
		acasMeta.setTagName(bean.getTagName());
		
		session.save(acasMeta);
	}
	
	public List<ACAS_Meta> getAcasMeta(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_meta");
		List<ACAS_Meta> acasMeta = query.list();
		session.close();
		return acasMeta;
	}
	
	public ACAS_Meta updateAcasProdRef(ACAS_Meta acas_meta) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_meta set messageID = :messageid, tagValue = :tagvalue, tagName = :tagname"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_meta.getUuid());
		query.setString("messageid", acas_meta.getMessageID());
		query.setString("tagvalue",acas_meta.getTagValue());
		query.setString("tagname", acas_meta.getTagName());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAcasMeta(acas_meta);
		}
		tx.commit();
		session.close();
		return acas_meta;
		
	}
	
	public int deleteAcasMeta(ACAS_Meta acas_meta) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_meta where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_meta.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}