package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.AnuncioDao;
import edu.fae.model.Anuncio;

/**
 * Implementa��o do AnuncioDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class AnuncioDaoHibernate extends AbstractDaoHibernate implements AnuncioDao {
	
	@Override
	public List<Anuncio> findNovos() {
		return getSession().createQuery("from Anuncio where situacao='Novo'").list();
	}	
	
	public List<Anuncio> findAll() {
		return getSession().createQuery("from Anuncio").list();
	}

	public Anuncio findById(Long id) {
		Query query = getSession().createQuery("from Anuncio where id=:id");
		query.setLong("id", id);
		return (Anuncio) query.uniqueResult();
	}

	public void remove(Anuncio anuncio) {
		getSession().delete(anuncio);
	}

	public void save(Anuncio anuncio) {
		getSession().saveOrUpdate(anuncio);
	}


	
}
