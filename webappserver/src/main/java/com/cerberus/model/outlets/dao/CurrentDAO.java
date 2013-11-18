package com.cerberus.model.outlets.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.Current;

public class CurrentDAO extends GenericDAO<Current, Integer> {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	public CurrentDAO(){
		super();
	}
	
	/***/
	public Current getById(Integer id){
		return getById(Current.class, id);
	}
	
	/***/
	public List<Current> getAll(){
		return getAll(Current.class);
	}
	
	public synchronized boolean deleteCurrent(Timestamp minDate){
		Session session = null;
		Transaction tx = null;
		boolean success = false;

		try{
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Add Custom Query Here
			Query querySetup = session.createSQLQuery("SET SQL_SAFE_UPDATES=0");
			Query query = session.createSQLQuery("delete from cerberus.current where timestamp < :thresholdTimestamp")
					.addEntity(Current.class)
					.setParameter("thresholdTimestamp", minDate);
			querySetup.executeUpdate();
			query.executeUpdate();
			session.flush();
			tx.commit();
			success = true;
		}catch (RuntimeException e) {
			tx.rollback();
			LOGGER.severe(e.getMessage());
			e.printStackTrace();
		}finally{
			session.close();
		}

		return success;
	}
	

}
