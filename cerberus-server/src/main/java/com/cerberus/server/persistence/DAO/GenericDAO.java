package com.cerberus.server.persistence.DAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;
import com.cerberus.server.persistence.HibernateUtil;

@Component
public class GenericDAO<T, ID extends Serializable> {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public GenericDAO(){
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	/***/
	@SuppressWarnings("unchecked")
	public T save(final T o){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T saved = (T) session.save(o);
		tx.commit();
		return saved;
	}

	/***/
	public void delete(final Object object){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		sessionFactory.getCurrentSession().delete(object);
		tx.commit();
	}

	/***/
	@SuppressWarnings("unchecked")
	protected T getById(final Class<T> clazz, final ID id){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T get = (T) sessionFactory.getCurrentSession().get(clazz, id);
		tx.commit();
		return get;
	}
	
	/***/
	@SuppressWarnings("unchecked")
	public T getByFilter(DetachedCriteria criteria){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		T get = (T) criteria.getExecutableCriteria(session).uniqueResult();
		
		tx.commit();
		return get;
	}

	/***/
	@SuppressWarnings("unchecked")
	public T merge(final T o)   {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T merged = (T) sessionFactory.getCurrentSession().merge(o);
		tx.commit();
		return merged;
	}

	/***/
	public void saveOrUpdate(final T o){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(o);
		tx.commit();
	}
	
	/***/
	@SuppressWarnings("unchecked")
	protected List<T> getAll(final Class<T> type) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		final Criteria criteria = session.createCriteria(type);
		List<T> list = criteria.list();
		
		tx.commit();
		return list;
	}
	
	/***/
	@SuppressWarnings("unchecked")
	public List<T> getAllByFilter(DetachedCriteria criteria){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<T> list = criteria.getExecutableCriteria(session).list();
				
		tx.commit();
		return list;
	}

}
