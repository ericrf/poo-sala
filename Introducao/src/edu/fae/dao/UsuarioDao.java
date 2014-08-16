package edu.fae.dao;

import java.util.List;

import edu.fae.model.Usuario;

/**
 * Definição de Dao de Usuário
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface UsuarioDao {
	
	/**
	 * Busca todos os usários
	 * 
	 * @return
	 */
	public List<Usuario> findAll();
	
}
