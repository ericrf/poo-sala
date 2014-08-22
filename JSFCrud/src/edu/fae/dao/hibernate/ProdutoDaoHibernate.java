package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.ProdutoDao;
import edu.fae.model.Produto;

/**
 * Implementação do ProdutoDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class ProdutoDaoHibernate extends AbstractDaoHibernate implements ProdutoDao {
	
	public List<Produto> findAll() {
		//Busca a sessão do Hibernate getSession()
		//Cria um HQL para buscar os produto
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from Produto").list();
	}

	public Produto findById(Long id) {
		//Cria a consulta de Produto por id
		Query query = getSession().createQuery("from Produto where id=:id");
		//Seta o parâmetro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (Produto) query.uniqueResult();
	}

	public void remove(Produto produto) {
		//Remove o produto da base de dados
		getSession().delete(produto);
	}

	public void save(Produto produto) {
		//Salva o produto
		//Faz as operação de update e insert
		//update quando o objeto tem id
		//insert quando o objeto não tem id
		getSession().saveOrUpdate(produto);
	}
	
}
