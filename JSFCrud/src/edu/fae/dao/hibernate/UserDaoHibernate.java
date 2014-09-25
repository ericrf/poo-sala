package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.UserDao;
import edu.fae.model.User;

/**
 * Implementa��o do UserDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class UserDaoHibernate extends AbstractDaoHibernate implements UserDao {
	
	public List<User> findAll() {
		return getSession().createQuery("from User").list();
	}

	public User findOneById(Long id) {
		Query query = getSession().createQuery("from User where id=:id");
		query.setLong("id", id);
		return (User) query.uniqueResult();
	}

	public void remove(User user) {
		getSession().delete(user);
	}

	public void save(User user) {
		getSession().saveOrUpdate(user);
	}


	
}
