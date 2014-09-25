package edu.fae.dao;

import edu.fae.dao.hibernate.CompanyDaoHibernate;
import edu.fae.dao.hibernate.EmployerDaoHibernate;
import edu.fae.dao.hibernate.PersonDaoHibernate;
import edu.fae.dao.hibernate.UserDaoHibernate;
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

	public static CompanyDao getCompanyDao() {
		return new CompanyDaoHibernate();
	}

	public static PersonDao getPersonDao() {
		return new PersonDaoHibernate();
	}

	public static UserDao getUserDao() {
		return new UserDaoHibernate();
	}		
	public static EmployerDao getEmployerDao() {
		return new EmployerDaoHibernate();
	}	

	
}
