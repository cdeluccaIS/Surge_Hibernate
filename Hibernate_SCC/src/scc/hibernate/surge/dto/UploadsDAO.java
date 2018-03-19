package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class UploadsDAO {
	
	public void addUpload(Uploads bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addUpload(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addUpload(Session session, Uploads bean) {
		Uploads upload = new Uploads();

		upload.setUuid(bean.getUuid());
		upload.setFileLocation(bean.getFileLocation());
		upload.setDate(bean.getDate());
		upload.setType(bean.getType());
		upload.setState(bean.getState());
		upload.setAuthority(bean.getAuthority());
		upload.setStatus(bean.getStatus());
		upload.setTimestamp(bean.getTimestamp());
		
		session.save(upload);
	}
	
	public List<Uploads> getUploads(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Account");
		List<Uploads> uploads = query.list();
		session.close();
		return uploads;
	}
	
	public Uploads updateUpload(Uploads upload) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update uploads set FileLocation = :flocation, Date = :date, Type = :type, State = :state, Authority = :authority, "
				+ "Status = :status, Timestamp = :timestamp"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", upload.getUuid());
		query.setString("flocation", upload.getFileLocation());
		query.setDate("date",upload.getDate());
		query.setString("type", upload.getType());
		query.setParameter("state", upload.getState());
		query.setParameter("authority", upload.getAuthority());
		query.setParameter("status", upload.getStatus());
		query.setParameter("timestamp",  upload.getTimestamp());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addUpload(upload);
		}
		tx.commit();
		session.close();
		return upload;
		
	}
	
	public int deleteUpload(Uploads upload) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from uploads where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid",  upload.getUuid());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}
