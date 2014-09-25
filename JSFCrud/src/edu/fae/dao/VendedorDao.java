package edu.fae.dao;

import java.util.List;

import edu.fae.model.Vendedor;

/**
 * Definição de Dao de vendedor
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface VendedorDao {
	/**
	 * Busca todos os vendedores
	 */
	public List<Vendedor> findAll();
	
	/**
	 * Salva um vendedor. Inserção e alteração
	 */
	public void save(Vendedor vendedor);
	
	/**
	 * Remove um vendedor
	 */
	public void remove(Vendedor vendedor);
	
	/**
	 * Procura um vendedor por id
	 */
	public Vendedor findById(Long id);
}
