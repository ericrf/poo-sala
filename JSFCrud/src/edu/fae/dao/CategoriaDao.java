package edu.fae.dao;

import java.util.List;

import edu.fae.model.Categoria;

/**
 * Definição de Dao de categoria
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface CategoriaDao {
	/**
	 * Busca todos os categorias
	 */
	public List<Categoria> findAll();
	
	/**
	 * Salva um categoria. Inserção e alteração
	 */
	public void save(Categoria categoria);
	
	/**
	 * Remove um categoria
	 */
	public void remove(Categoria categoria);
	
	/**
	 * Procura um categoria por id
	 */
	public Categoria findById(Long id);
}
