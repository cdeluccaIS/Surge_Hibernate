package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class DocumentDAO {
	
	public void addDoc(Document bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addDoc(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addDoc(Session session, Document bean) {
		Document document = new Document();

		document.setUuid(bean.getUuid());
		document.setLocation(bean.getLocation());
		
		
		session.save(document);
	}
	
	public List<Document> getDocs(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from document");
		List<Document> documents = query.list();
		session.close();
		return documents;
	}
	
	public Document updateDoc(Document document) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update document set Location = :location"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", document.getUuid());
		query.setString("location", document.getLocation());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addDoc(document);
		}
		tx.commit();
		session.close();
		return document;
		
	}
	
	public int deleteDoc(Document document) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from document where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid",  document.getUuid());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}
