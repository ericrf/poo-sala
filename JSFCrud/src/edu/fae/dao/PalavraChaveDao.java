package edu.fae.dao;

import java.util.List;

import edu.fae.model.PalavraChave;

/**
 * Definição de Dao de palavraChave
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface PalavraChaveDao {
	/**
	 * Busca todos os palavra
	 */
	public List<PalavraChave> findAll();
	
	/**
	 * Salva um palavraChave. Inserção e alteração
	 */
	public void save(PalavraChave palavraChave);
	
	/**
	 * Remove um palavraChave
	 */
	public void remove(PalavraChave palavraChave);
	
	/**
	 * Procura um palavraChave por id
	 */
	public PalavraChave findById(Long id);
}
