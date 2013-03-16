package com.cerberus.server.persistence.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.cerberus.server.persistence.HibernateUtil;

@Component
public class GenericDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public GenericDAO(){
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public <T> T save(final T o){
		Session session = sessionFactory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		T savedO = (T) session.save(o);
		trans.commit();
		return savedO;
	}


	public void delete(final Object object){
		sessionFactory.getCurrentSession().delete(object);
	}

	/***/
	public <T> T get(final Class<T> type, final Long id){
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	/***/
	public <T> T merge(final T o)   {
		return (T) sessionFactory.getCurrentSession().merge(o);
	}

	/***/
	public <T> void saveOrUpdate(final T o){
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	public <T> List<T> getAll(final Class<T> type) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}


}
