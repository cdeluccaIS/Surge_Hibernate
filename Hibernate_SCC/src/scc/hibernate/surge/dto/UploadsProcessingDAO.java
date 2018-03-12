package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class UploadsProcessingDAO {
	
	public void addUpProcess(UploadsProcessing bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addUpProcess(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addUpProcess(Session session, UploadsProcessing bean) {
		UploadsProcessing uploadP = new UploadsProcessing();

		uploadP.setUuid(bean.getUuid());
		uploadP.setDocument(bean.getDocument());
		uploadP.setUpload(bean.getUpload());
		uploadP.setpCompletion(bean.getpCompletion());
		uploadP.setState(bean.getState());
		
		session.save(uploadP);
	}
	
	public List<UploadsProcessing> getUpProceess(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from UploadsProcessing");
		List<UploadsProcessing> uploads = query.list();
		session.close();
		return uploads;
	}
	
	public UploadsProcessing updateUpProcess(UploadsProcessing upload) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update uploadsprocessing set document = :document, upload = :upload, pCompletion = :pcompletion, State = :state"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", upload.getUuid());
		query.setParameter("document", upload.getDocument());
		query.setParameter("upload",upload.getUpload());
		query.setInteger("pcompletion", upload.getpCompletion());
		query.setParameter("state", upload.getState());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addUpProcess(upload);
		}
		tx.commit();
		session.close();
		return upload;
		
	}
	
	public int deleteUpProcess(UploadsProcessing upload) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from uploadsprocessing where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", upload.getUuid());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}
