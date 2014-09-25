package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.VendedorDao;
import edu.fae.model.Vendedor;

/**
 * Implementação do VendedorDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class VendedorDaoHibernate extends AbstractDaoHibernate implements VendedorDao {
	
	public List<Vendedor> findAll() {
		return getSession().createQuery("from Vendedor").list();
	}

	public Vendedor findById(Long id) {
		Query query = getSession().createQuery("from Vendedor where id=:id");
		query.setLong("id", id);
		return (Vendedor) query.uniqueResult();
	}

	public void remove(Vendedor vendedor) {
		getSession().delete(vendedor);
	}

	public void save(Vendedor vendedor) {
		getSession().saveOrUpdate(vendedor);
	}
	
}
