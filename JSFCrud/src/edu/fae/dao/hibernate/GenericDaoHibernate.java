package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;


@SuppressWarnings("unchecked")
public class GenericDaoHibernate<E> implements ObjectDao<E>{
	private String tableName;

	public GenericDaoHibernate(E object) {
		this.tableName = object.getClass().getSimpleName();
	}
	
	@Override
	public List<E> findAll() {
		HibernateUtil.getSession().beginTransaction();		
		
		Query query = HibernateUtil.getSession()
				.createQuery("from " + tableName);
		List<E> characters = query.list();

		HibernateUtil.getSession().getTransaction().commit();
		return characters;
		
	}

	@Override
	public void save(Object object) {
		HibernateUtil.getSession().beginTransaction();
				
		HibernateUtil.getSession().saveOrUpdate(object);
		
		HibernateUtil.getSession().getTransaction().commit();
		
	}

	@Override
	public E findById(int id) {

		HibernateUtil.getSession().beginTransaction();		
		
		
		Query query = HibernateUtil.getSession().createQuery("from " +tableName+ " where id=:id");
		query.setLong("id", id);
		
		E usuario = (E) query.uniqueResult();
		
		HibernateUtil.getSession().getTransaction().commit();

		
		return usuario;
	}

	@Override
	public void remove(Object object) {
		HibernateUtil.getSession().beginTransaction();
		
		HibernateUtil.getSession().delete(object);
		
		HibernateUtil.getSession().getTransaction().commit();
	}

}
