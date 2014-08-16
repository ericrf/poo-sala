package edu.fae.dao;

import edu.fae.dao.hibernate.UsuarioDaoHibernate;

/**
 * Factory de Dao
 * @author Robson J. P.
 * @since 1.0
 */
public class DaoFactory {
	
	/**
	 * Cria a implementação do UsuarioDao
	 * @return
	 */
	public static UsuarioDao getUsuarioDao() {
		return new UsuarioDaoHibernate();
	}
	
}
