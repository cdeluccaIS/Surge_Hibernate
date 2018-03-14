package scc.hibernate.surge.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class AccountDAO {
	
	public void addAccount(AccountDetails bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addAccount(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addAccount(Session session, AccountDetails bean) {
		AccountDetails account = new AccountDetails();

		account.setUuid(bean.getUuid());
		account.setFirstName(bean.getFirstName());
		account.setMiddleInitial(bean.getMiddleInitial());
		account.setLastName(bean.getLastName());
		account.setEmail(bean.getEmail());
		account.setSecurePhone(bean.getSecurePhone());
		account.setAgency(bean.getAgency());
		account.setCitizenship(bean.getCitizenship());
		account.setClearance(bean.getClearance());
		account.setAccountType(bean.getAccountType());
		account.setAccountStatus(bean.getAccountStatus());
		account.setPassword(bean.getPassword());
		account.setLock(bean.isLock());
		
		session.save(account);
	}
	
	public List<AccountDetails> getAccounts(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Account");
		List<AccountDetails> accounts = query.list();
		session.close();
		return accounts;
	}
	
	public AccountDetails updateAccount(AccountDetails account) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Account set firstName = :fname, lastName = :lname, Email = :email, SecurePhone = :sphone, Agency = :agency, "
				+ "Citizenship = :citizenship, Clearance = :clearance, AccountType = :accType, AccountStatus = :accStatus, password = :password, lock = :lock"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", account.getUuid());
		query.setString("fname", account.getFirstName());
		query.setString("lname",account.getLastName());
		query.setString("email", account.getEmail());
		query.setString("sphone", account.getSecurePhone());
		query.setParameter("agency", account.getAgency());
		query.setParameter("citizenship", account.getCitizenship());
		query.setString("clearance",  account.getClearance());
		query.setString("accType", account.getAccountType());
		query.setString("accStatus", account.getAccountStatus());
		query.setString("password", account.getPassword());
		query.setBoolean("lock", account.isLock());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addAccount(account);
		}
		tx.commit();
		session.close();
		return account;
		
	}
	
	public int deleteAccount(AccountDetails account) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Account where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid",  account.getUuid());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
}
