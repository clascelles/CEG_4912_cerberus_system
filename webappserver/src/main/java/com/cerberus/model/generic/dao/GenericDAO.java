package com.cerberus.model.generic.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

import com.cerberus.frameworks.hibernate.HibernateUtil;
//import javax.annotation.Resource;

@Component
public class GenericDAO<T, ID extends Serializable> {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	//@Resource(name = "sessionFactory")
	private final SessionFactory sessionFactory;

	public GenericDAO(){
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	/***/
	@SuppressWarnings("unchecked")
	public synchronized ID save(final T o){
		Session session = null;
		Transaction tx = null;
		ID saved = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			saved = (ID) session.save(o);
			session.flush();
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			LOGGER.severe(e.getMessage());
			e.printStackTrace();
		}finally{
			session.close();
		}

		return saved;
	}

	/***/
	public void delete(final Object object){
		Session session = null;
		Transaction tx = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(object);
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/***/
	@SuppressWarnings("unchecked")
	protected T getById(final Class<T> clazz, final ID id){
		Session session = null;
		Transaction tx = null;
		T get = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			get = (T) session.get(clazz, id);
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return get;
	}

	/***/
	@SuppressWarnings("unchecked")
	public T getByFilter(DetachedCriteria criteria){
		Session session = null;
		Transaction tx = null;
		T get = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			get = (T) criteria.getExecutableCriteria(session).uniqueResult();
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return get;
	}
	
	/***/
	public Long count(DetachedCriteria criteria){
		Session session = null;
		Transaction tx = null;
		Long count = 0L;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			count = (Long) criteria.getExecutableCriteria(session).setProjection(Projections.rowCount()).uniqueResult();
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return count;
	}

	/***/
	@SuppressWarnings("unchecked")
	public T merge(final T o)   {
		Session session = null;
		Transaction tx = null;
		T merged = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			merged = (T) session.merge(o);
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return merged;
	}

	/***/
	public void saveOrUpdate(final T o){
		Session session = null;
		Transaction tx = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(o);
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	/***/
	@SuppressWarnings("unchecked")
	protected List<T> getAll(final Class<T> type) {
		Session session = null;
		Transaction tx = null;
		List<T> list = null;

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			final Criteria criteria = session.createCriteria(type);
			list = criteria.list();
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return list;
	}

	/***/
	@SuppressWarnings("unchecked")
	public List<T> getAllByFilter(DetachedCriteria criteria){
		Session session = null;
		Transaction tx = null;
		List<T> list = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			list = criteria.getExecutableCriteria(session).list();
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return list;
	}
	
	/***/
	@SuppressWarnings("unchecked")
	public List<Integer> getAllIdsByFilter(DetachedCriteria criteria){		
		Session session = null;
		Transaction tx = null;
		List<Integer> list = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			list = criteria.getExecutableCriteria(session).list();
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return list;
	}
	
	protected SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
