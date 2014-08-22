package edu.fae.dao;

import java.util.List;

import edu.fae.model.Produto;

/**
 * Defini��o de Dao de produto
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface ProdutoDao {
	/**
	 * Busca todos os produtos
	 */
	public List<Produto> findAll();
	
	/**
	 * Salva um produto. Inser��o e altera��o
	 */
	public void save(Produto produto);
	
	/**
	 * Remove um produto
	 */
	public void remove(Produto produto);
	
	/**
	 * Procura um produto por id
	 */
	public Produto findById(Long id);
}
