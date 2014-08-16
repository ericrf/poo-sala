package edu.fae.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.UsuarioDao;
import edu.fae.model.Usuario;

/**
 * 
 * @author Robson J. P.
 *
 */
@RequestScoped
@ManagedBean(name="usuarioController")
public class UsuarioController {
	//Refer�ncia para o Dao do Usu�rio
	private UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
	
	/**
	 * Retorna os usu�rios cadastrados
	 * @return
	 */
	public List<Usuario> getUsuarios() {
		return usuarioDao.findAll();
	}
	
}
