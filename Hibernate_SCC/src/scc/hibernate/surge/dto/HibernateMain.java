package scc.hibernate.surge.dto;

import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	public static void main(String[] args) {
		AccountDetails account = new AccountDetails();
		Agencies agency = new Agencies();
		UUID uuid = UUID.randomUUID();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		/* Set up Agency table 
		UUID agent_uuid = UUID.randomUUID();
		agency.setUuid(agent_uuid);
		agency.setAgency_name("NSA");
		commit(agency, session);
		agency = null;
		UUID agent_uuid2 = UUID.randomUUID();
		agency = new Agencies();
		agency.setUuid(agent_uuid2);
		agency.setAgency_name("DIA");
		commit(agency, session);
		*/
		
		/* Set up Account table
		
		account.setUuid(uuid);
		account.setFirstName("John");
		account.setLastName("Davis");
		account.setAgency(agent_uuid2);
		commit(account, session);	
		*/
		/* Close our session */
		//session.close();
		
		/* setting to null so fetch can pull new objects in */
		//account=null;


		/* Fetch */
		//session = sessionFactory.openSession();
		session.beginTransaction();
		String id = "b491eb69-72b2-4577-8766-63cfe5a9b32f";
		uuid = UUID.fromString(id);
		
		account = (AccountDetails) session.get(AccountDetails.class, uuid);
		UUID account_agency = account.getAgency();
		agency = (Agencies) session.get(Agencies.class, account_agency);
		
		System.out.println("User Name retreived is " + account.getFirstName() + " " + account.getLastName());
		System.out.println("Agency associated is " + agency.getAgency_name());
		System.out.println("UUID for this account is " + account.getUuid());
		System.out.println("Agency UUID is " + agency.getUuid());
		
		/* Close our session */
		session.close();
	}
		/* Setup Location table */
		/* Setup State table */
		/* Setup Country table */
		/* Setup Audit table */
		/* Setup Application table */
		
		
	
	
	public static void getAccount(UUID uuid) {
		
	}
		
	public static void commit(Object data, Object session) {
		((SharedSessionContract) session).beginTransaction();
		((Session) session).save(data);
		((SharedSessionContract) session).getTransaction().commit();
	}
		
}
