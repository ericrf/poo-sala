package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.EmployerDao;
import edu.fae.model.Employer;

/**
 * Implementa��o do UserDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class EmployerDaoHibernate extends AbstractDaoHibernate implements EmployerDao {
	
	public List<Employer> findAll() {
		return getSession().createQuery("from User").list();
	}

	public Employer findOneById(Long id) {
		Query query = getSession().createQuery("from Employer where id=:id");
		query.setLong("id", id);
		return (Employer) query.uniqueResult();
	}

	public void remove(Employer user) {
		getSession().delete(user);
	}

	public void save(Employer user) {
		getSession().saveOrUpdate(user);
	}


	
}
