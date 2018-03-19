package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class CountryDAO {
	
	public void addCountry(Country bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addCountry(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addCountry(Session session, Country bean) {
		Country country = new Country();

		country.setUuid(bean.getUuid());
		country.setName(bean.getName());
		country.setCode(bean.getCode());
		
		session.save(country);
	}
	
	public List<Country> getCountry(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from country");
		List<Country> country = query.list();
		session.close();
		return country;
	}
	
	public Country updateCountry(Country country) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update country set name = :name, code = :code"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", country.getUuid());
		query.setString("name", country.getName());
		query.setString("code",country.getCode());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addCountry(country);
		}
		tx.commit();
		session.close();
		return country;
		
	}
	
	public int deleteCountry(Country country) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from country where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", country.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}