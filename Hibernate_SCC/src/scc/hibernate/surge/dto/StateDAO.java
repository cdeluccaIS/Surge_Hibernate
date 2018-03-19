package scc.hibernate.surge.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

public class StateDAO {
	
	public void addState(State bean) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		addState(session,bean);
		tx.commit();
		session.close();
	}
	
	private void addState(Session session, State bean) {
		State state = new State();

		state.setUuid(bean.getUuid());
		state.setName(bean.getName());
		state.setAbbr(bean.getAbbr());
		
		session.save(state);
	}
	
	public List<State> getState(){
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from state");
		List<State> states = query.list();
		session.close();
		return states;
	}
	
	public State updateState(State state) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update state set name = :name, abbr = :abbr"
				+ " WHERE uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", state.getUuid());
		query.setString("name", state.getName());
		query.setString("abbr",state.getAbbr());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		
		if (rowCount == 0) {
			addState(state);
		}
		tx.commit();
		session.close();
		return state;
		
	}
	
	public int deleteState(State state) {
		
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from state where uuid = :uuid";
		Query query = session.createQuery(hql);
		query.setParameter("uuid", state.getUuid());
		
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}