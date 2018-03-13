package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class ACAS_ARF_ConfigDAO {
	
	public void addACAS_ARF_Config(ACAS_ARF_Config bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addACAS_ARF_Config(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addACAS_ARF_Config(Session session, ACAS_ARF_Config bean) {
		ACAS_ARF_Config acas_arf_config = new ACAS_ARF_Config();

		acas_arf_config.setUuid(bean.getUuid());
		acas_arf_config.setNetworkConfig(bean.getNetworkConfig());
		acas_arf_config.setCpeInv(bean.getCpeInv());
		
		session.save(acas_arf_config);
	}
	
	public List<ACAS_ARF_Config> getACAS_ARF_Config(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from acas_arf_config");
		List<ACAS_ARF_Config> acas_arf_config = query.list();
		session.close();
		return acas_arf_config;
	}
	
	public ACAS_ARF_Config updateACAS_ARF_Config(ACAS_ARF_Config acas_arf_config) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update acas_arf_config set networkconfig = :ncfg, cpeinv = :cpe"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_config.getUuid());
		query.setParameter("ncfg", acas_arf_config.getNetworkConfig());
		query.setParameter("cpe",acas_arf_config.getCpeInv());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addACAS_ARF_Config(acas_arf_config);
		}
		tx.commit();
		session.close();
		return acas_arf_config;
		
	}
	
	public int deleteACAS_ARF_Config(ACAS_ARF_Config acas_arf_config) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from acas_arf_config where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", acas_arf_config.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}