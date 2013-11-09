package com.cerberus.model.usage.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.CurrentHour;

public class CurrentHourDAO extends GenericDAO<CurrentHour, Integer> {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public CurrentHourDAO(){
		super();
	}
	
	/***/
	public CurrentHour getById(Integer id){
		return getById(CurrentHour.class, id);
	}
	
	/***/
	public List<CurrentHour> getAll(){
		return getAll(CurrentHour.class);
	}
	
	public synchronized boolean updateCurrentHour(Timestamp minDate){
		Session session = null;
		Transaction tx = null;
		boolean success = false;

		try{
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			//Add Custom Query Here
			Query query = session.createSQLQuery("Select * from Cerberus.Current_Hour")
					.addEntity(CurrentHour.class);
			//query.executeUpdate();
			List<CurrentHour> cur = query.list();
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
