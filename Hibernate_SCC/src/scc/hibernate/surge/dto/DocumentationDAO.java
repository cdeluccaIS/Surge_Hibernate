package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class DocumentationDAO {
	
	public void addDocumentation(Documentation bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addDocumentation(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addDocumentation(Session session, Documentation bean) {
		Documentation documentation = new Documentation();

		documentation.setUuid(bean.getUuid());
		documentation.setXmlTemplate(bean.getXmlTemplate());
		documentation.setXlsTemplate(bean.getXlsTemplate());
		documentation.setJsonTemplate(bean.getJsonTemplate());
		documentation.setInstructions(bean.getInstructions());
		documentation.setApilmpDoc(bean.getApilmpDoc());
		
		session.save(documentation);
	}
	
	public List<Documentation> getDocumentation(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from documentation");
		List<Documentation> documentation = query.list();
		session.close();
		return documentation;
	}
	
	public Documentation updateDocumentation(Documentation documentation) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update documentation set XmlTemplate = :xmltemp, XlsTemplate = :xlstemp, JsonTemplate = :jsontemplate, Instructions = :instructions, ApilmpDoc = :apilmpdoc"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", documentation.getUuid());
		query.setString("xmltemp", documentation.getXmlTemplate());
		query.setString("xlstemp",documentation.getXlsTemplate());
		query.setString("jsontemplate", documentation.getJsonTemplate());
		query.setString("instructions", documentation.getInstructions());
		query.setParameter("apilmpdoc", documentation.getApilmpDoc());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addDocumentation(documentation);
		}
		tx.commit();
		session.close();
		return documentation;
		
	}
	
	public int deleteDocumentation(Documentation documentation) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from documentation where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid",  documentation.getUuid());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}