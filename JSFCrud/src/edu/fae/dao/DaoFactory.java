package edu.fae.dao;

import edu.fae.dao.hibernate.CategoriaDaoHibernate;
import edu.fae.dao.hibernate.PalavraChaveDaoHibernate;
import edu.fae.dao.hibernate.ProdutoDaoHibernate;
import edu.fae.dao.hibernate.UsuarioDaoHibernate;

/**
 * Factory de Dao
 * @author Robson J. P.
 * @since 1.0
 */
public class DaoFactory {
	
	public static UsuarioDao getUsuarioDao() {
		return new UsuarioDaoHibernate();
	}
	
	public static ProdutoDao getProdutoDao() {
		return new ProdutoDaoHibernate();
	}	
	
	public static CategoriaDao getCategoriaDao() {
		return new CategoriaDaoHibernate();
	}		
	
	public static PalavraChaveDao getPalavraChaveDao() {
		return new PalavraChaveDaoHibernate();
	}
	
}
