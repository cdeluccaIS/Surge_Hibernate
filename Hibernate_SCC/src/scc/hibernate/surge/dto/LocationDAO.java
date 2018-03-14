package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class LocationDAO {
	
	public void addLocation(Location bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addLocation(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addLocation(Session session, Location bean) {
		Location location = new Location();

		location.setUuid(bean.getUuid());
		location.setLocation_name(bean.getLocation_name());
		location.setLocation_id(bean.getLocation_id());
		location.setAddress1(bean.getAddress1());
		location.setAddress2(bean.getAddress2());
		location.setCity(bean.getCity());
		location.setState(bean.getState());
		location.setZip_code(bean.getZip_code());
		
		session.save(location);
	}
	
	public List<Location> getLocation(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from location");
		List<Location> locations = query.list();
		session.close();
		return locations;
	}
	
	public Location updateLocation(Location location) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update location set location_name = :location, location_id = :id, address1 = :addr1, address2 = :addr2, city = :city, state = :state, zip_code = :zip_code"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", location.getUuid());
		query.setString("location_name", location.getLocation_name());
		query.setString("location_id",location.getLocation_id());
		query.setString("address1",location.getAddress1());
		query.setString("address2",location.getAddress2());
		query.setString("city",location.getCity());
		query.setParameter("state",location.getState());
		query.setInteger("zip_code",location.getZip_code());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addLocation(location);
		}
		tx.commit();
		session.close();
		return location;
		
	}
	
	public int deleteLocation(Location location) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from location where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", location.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}