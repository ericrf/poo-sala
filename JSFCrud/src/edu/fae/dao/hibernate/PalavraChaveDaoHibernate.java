package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.PalavraChaveDao;
import edu.fae.model.PalavraChave;

/**
 * Implementação do PalavraChaveDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class PalavraChaveDaoHibernate extends AbstractDaoHibernate implements PalavraChaveDao {
	
	public List<PalavraChave> findAll() {
		//Busca a sessão do Hibernate getSession()
		//Cria um HQL para buscar os palavraChave
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from PalavraChave").list();
	}

	public PalavraChave findById(Long id) {
		//Cria a consulta de PalavraChave por id
		Query query = getSession().createQuery("from PalavraChave where id=:id");
		//Seta o parâmetro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (PalavraChave) query.uniqueResult();
	}

	public void remove(PalavraChave palavraChave) {
		//Remove o palavraChave da base de dados
		getSession().delete(palavraChave);
	}

	public void save(PalavraChave palavraChave) {
		//Salva o palavraChave
		//Faz as operação de update e insert
		//update quando o objeto tem id
		//insert quando o objeto não tem id
		getSession().saveOrUpdate(palavraChave);
	}
	
}
