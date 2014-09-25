package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.PersonDao;
import edu.fae.model.Person;

/**
 * Implementa��o do PersonDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class PersonDaoHibernate extends AbstractDaoHibernate implements PersonDao {
	
	public List<Person> findAll() {
		return getSession().createQuery("from Person").list();
	}

	public Person findOneById(Long id) {
		Query query = getSession().createQuery("from Person where id=:id");
		query.setLong("id", id);
		return (Person) query.uniqueResult();
	}

	public void remove(Person person) {
		getSession().delete(person);
	}

	public void save(Person person) {
		getSession().saveOrUpdate(person);
	}


	
}
