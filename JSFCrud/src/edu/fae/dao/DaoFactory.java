package edu.fae.dao;

import edu.fae.dao.hibernate.AnuncioDaoHibernate;
import edu.fae.dao.hibernate.CategoriaDaoHibernate;
import edu.fae.dao.hibernate.CompanyDaoHibernate;
import edu.fae.dao.hibernate.PalavraChaveDaoHibernate;
import edu.fae.dao.hibernate.PersonDaoHibernate;
import edu.fae.dao.hibernate.ProdutoDaoHibernate;
import edu.fae.dao.hibernate.UsuarioDaoHibernate;
import edu.fae.dao.hibernate.VendedorDaoHibernate;

/**
 * Factory de Dao
 * @author Robson J. P.
 * @since 1.0
 */
public class DaoFactory {
	

	
	public static CategoriaDao getCategoriaDao() {
		return new CategoriaDaoHibernate();
	}		
	
	public static VendedorDao getVendedorDao() {
		return new VendedorDaoHibernate();
	}		

	public static AnuncioDao getAnuncioDao() {
		return new AnuncioDaoHibernate();
	}

	public static ProdutoDao getProdutoDao() {
		return new ProdutoDaoHibernate();
	}

	public static PalavraChaveDao getPalavraChaveDao() {
		return new PalavraChaveDaoHibernate();
	}

	public static UsuarioDao getUsuarioDao() {
		return new UsuarioDaoHibernate();
	}

	public static CompanyDao getCompanyDao() {
		return new CompanyDaoHibernate();
	}

	public static PersonDao getPersonDao() {
		return new PersonDaoHibernate();
	}		

	
}
