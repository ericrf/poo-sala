package edu.fae.dao;

import java.util.List;

import edu.fae.model.Usuario;

/**
 * Defini��o de Dao de Usu�rio
 * 
 * @author Robson J. P.
 * @since 1.0
 */
public interface UsuarioDao {
	
	/**
	 * Busca todos os us�rios
	 * 
	 * @return
	 */
	public List<Usuario> findAll();
	
	/**
	 * Salva um usu�rio. Inser��o e altera��o
	 * 
	 * @param usuario
	 */
	public void save(Usuario usuario);
	
	/**
	 * Remove um usu�rio
	 * @param usuario
	 */
	public void remove(Usuario usuario);
	
	/**
	 * Procura um usu�rio por id
	 * @param id 
	 * @return Usu�rio encontrado
	 */
	public Usuario findById(Long id);
}
