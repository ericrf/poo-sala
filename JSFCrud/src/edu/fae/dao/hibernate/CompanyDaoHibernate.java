package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.CompanyDao;
import edu.fae.model.Company;

/**
 * Implementa��o do CompanyDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class CompanyDaoHibernate extends AbstractDaoHibernate implements CompanyDao {
	
	public List<Company> findAll() {
		return getSession().createQuery("from Company").list();
	}

	public Company findOneById(Long id) {
		Query query = getSession().createQuery("from Company where id=:id");
		query.setLong("id", id);
		return (Company) query.uniqueResult();
	}

	public void remove(Company company) {
		getSession().delete(company);
	}

	public void save(Company company) {
		getSession().saveOrUpdate(company);
	}


	
}
