package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.CategoriaDao;
import edu.fae.model.Categoria;

/**
 * Implementação do CategoriaDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class CategoriaDaoHibernate extends AbstractDaoHibernate implements CategoriaDao {
	
	public List<Categoria> findAll() {
		//Busca a sessão do Hibernate getSession()
		//Cria um HQL para buscar os categoria
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from Categoria").list();
	}

	public Categoria findById(Long id) {
		//Cria a consulta de Categoria por id
		Query query = getSession().createQuery("from Categoria where id=:id");
		//Seta o parâmetro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (Categoria) query.uniqueResult();
	}

	public void remove(Categoria categoria) {
		//Remove o categoria da base de dados
		getSession().delete(categoria);
	}

	public void save(Categoria categoria) {
		//Salva o categoria
		//Faz as operação de update e insert
		//update quando o objeto tem id
		//insert quando o objeto não tem id
		getSession().saveOrUpdate(categoria);
	}
	
}
