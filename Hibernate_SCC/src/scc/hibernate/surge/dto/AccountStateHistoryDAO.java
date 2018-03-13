package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class AccountStateHistoryDAO {
	
	public void addAccountStateHistory(AccountStateHistory bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAccountStateHistory(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAccountStateHistory(Session session, AccountStateHistory bean) {
		AccountStateHistory accountstatehistory = new AccountStateHistory();

		accountstatehistory.setUuid(bean.getUuid());
		accountstatehistory.setAccount(bean.getAccount());
		accountstatehistory.setAdmin(bean.getAdmin());
		accountstatehistory.setStatus(bean.getStatus());
		accountstatehistory.setDate(bean.getDate());
		accountstatehistory.setJustification(bean.getJustification());
		
		session.save(accountstatehistory);
	}
	
	public List<AccountStateHistory> getAccountStateHistory(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from accountstatehistory");
		List<AccountStateHistory> accountstatehistory = query.list();
		session.close();
		return accountstatehistory;
	}
	
	public AccountStateHistory updateAccountStateHistory(AccountStateHistory accountstatehistory) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update accountstatehistory set deviceid = :deviceid, identifiers = :ident, op_attr = :op_attr, configuration = :config, timestamp = :timestamp, tagged = :tag"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", accountstatehistory.getUuid());
		query.setParameter("account", accountstatehistory.getAccount());
		query.setParameter("admin",accountstatehistory.getAdmin());
		query.setString("status",accountstatehistory.getStatus());
		query.setDate("date",accountstatehistory.getDate());
		query.setString("justification",accountstatehistory.getJustification());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAccountStateHistory(accountstatehistory);
		}
		tx.commit();
		session.close();
		return accountstatehistory;
		
	}
	
	public int deleteAccountStateHistory(AccountStateHistory accountstatehistory) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from accountstatehistory where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", accountstatehistory.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}
