package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class AgenciesDAO {
	
	public void addAgencies(Agencies bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAgencies(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAgencies(Session session, Agencies bean) {
		Agencies agency = new Agencies();

		agency.setUuid(bean.getUuid());
		agency.setAgency_name(bean.getAgency_name());
		agency.setAgency_code(bean.getAgency_code());
		agency.setLocation_id(bean.getLocation_id());
		
		session.save(agency);
	}
	
	public List<Agencies> getAgencies(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from agencies");
		List<Agencies> agencies = query.list();
		session.close();
		return agencies;
	}
	
	public Agencies updateAgencies(Agencies agencies) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update agencies set agency_name = :name, agency_code = :code, location_id = :location"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", agencies.getUuid());
		query.setString("name", agencies.getAgency_name());
		query.setString("code",agencies.getAgency_code());
		query.setString("location",agencies.getLocation_id());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAgencies(agencies);
		}
		tx.commit();
		session.close();
		return agencies;
		
	}
	
	public int deleteAgencies(Agencies agencies) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from agencies where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", agencies.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}