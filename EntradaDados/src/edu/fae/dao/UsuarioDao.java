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
	
	/**
	 * Salva um usuário. Inserção e alteração
	 * 
	 * @param usuario
	 */
	public void save(Usuario usuario);
	
	/**
	 * Remove um usuário
	 * @param usuario
	 */
	public void remove(Usuario usuario);
	
	/**
	 * Procura um usuário por id
	 * @param id 
	 * @return Usuário encontrado
	 */
	public Usuario findById(Long id);
}
