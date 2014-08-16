package edu.fae.dao.hibernate;

import java.util.List;

import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;

/**
 * Implementa��o do UsuarioDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class UsuarioDaoHibernate extends AbstractDaoHibernate implements UsuarioDao {
	
	public List<Usuario> findAll() {
		//Busca a sess�o do Hibernate getSession()
		//Cria um HQL para buscar os usu�rio
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from Usuario").list();
	}

}
