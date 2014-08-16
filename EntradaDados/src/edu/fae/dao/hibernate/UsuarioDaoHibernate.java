package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;

/**
 * Implementação do UsuarioDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class UsuarioDaoHibernate extends AbstractDaoHibernate implements UsuarioDao {
	
	public List<Usuario> findAll() {
		//Busca a sessão do Hibernate getSession()
		//Cria um HQL para buscar os usuário
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from Usuario").list();
	}

	public Usuario findById(Long id) {
		//Cria a consulta de Usuario por id
		Query query = getSession().createQuery("from Usuario where id=:id");
		//Seta o parâmetro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (Usuario) query.uniqueResult();
	}

	public void remove(Usuario usuario) {
		//Remove o usuário da base de dados
		getSession().delete(usuario);
	}

	public void save(Usuario usuario) {
		//Salva o usuário
		//Faz as operação de update e insert
		//update quando o objeto tem id
		//insert quando o objeto não tem id
		getSession().saveOrUpdate(usuario);
	}
	
}
