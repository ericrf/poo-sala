package edu.fae.dao;

import java.util.List;

import edu.fae.model.Anuncio;

/**
 * Defini��o de Dao de anuncio
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface AnuncioDao {
	/**
	 * Busca todos os anuncios
	 */
	public List<Anuncio> findAll();
	
	public List<Anuncio> findNovos();
	
	/**
	 * Salva um anuncio. Inser��o e altera��o
	 */
	public void save(Anuncio anuncio);
	
	/**
	 * Remove um anuncio
	 */
	public void remove(Anuncio anuncio);
	
	/**
	 * Procura um anuncio por id
	 */
	public Anuncio findById(Long id);
}
