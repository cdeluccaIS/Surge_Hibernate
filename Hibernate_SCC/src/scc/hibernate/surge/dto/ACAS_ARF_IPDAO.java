package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_IPDAO {
	
	public void addACAS_ARF_IP(ACAS_ARF_IP bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_IP(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_IP(Session session, ACAS_ARF_IP bean) {
		ACAS_ARF_IP acas_arf_ip = new ACAS_ARF_IP();

		acas_arf_ip.setUuid(bean.getUuid());
		acas_arf_ip.setIpv4(bean.getIpv4());
		acas_arf_ip.setIpv6(bean.getIpv6());
		
		session.save(acas_arf_ip);
	}
	
	public List<ACAS_ARF_IP> getACAS_ARF_IP(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_ip");
		List<ACAS_ARF_IP> acas_arf_ip = query.list();
		session.close();
		return acas_arf_ip;
	}
	
	public ACAS_ARF_IP updateACAS_ARF_IP(ACAS_ARF_IP acas_arf_ip) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_ip set ipv4 = :ipv4, ipv6 = :ipv6"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_ip.getUuid());
		query.setString("ipv4", acas_arf_ip.getIpv4());
		query.setParameter("ipv6",acas_arf_ip.getIpv6());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_IP(acas_arf_ip);
		}
		tx.commit();
		session.close();
		return acas_arf_ip;
		
	}
	
	public int deleteACAS_ARF_IP(ACAS_ARF_IP acas_arf_ip) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_ip where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_ip.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}