package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.CityDao;
import edu.fae.model.Categoria;
import edu.fae.model.City;

/**
 * Implementação do CategoriaDao em Hibernate
 * @author Robson J. P.
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class CityDaoHibernate extends AbstractDaoHibernate implements CityDao {
	

	public List<City> findAll() {
		//Busca a sessão do Hibernate getSession()
		//Cria um HQL para buscar os categoria
		//E retorna uma lista com o resultado da consulta HQL
		return getSession().createQuery("from City").list();
	}

	public City findById(Long id) {
		//Cria a consulta de Categoria por id
		Query query = getSession().createQuery("from City where id=:id");
		//Seta o parâmetro id
		query.setLong("id", id);
		//Executa a consulta retornando um resultado apenas
		return (City) query.uniqueResult();
	}

	public void remove(City object) {
		//Remove o categoria da base de dados
		getSession().delete(object);
	}

	public void save(City object) {
		//Salva o categoria
		//Faz as operação de update e insert
		//update quando o objeto tem id
		//insert quando o objeto não tem id
		getSession().saveOrUpdate(object);
	}

	@Override
	public City findOneById(Long id) {
		// TODO Auto-generated method stub
		return findById(id);
	}
	
}
