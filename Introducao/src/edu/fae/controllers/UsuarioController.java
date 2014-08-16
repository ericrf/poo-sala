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
	//Referência para o Dao do Usuário
	private UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
	
	/**
	 * Retorna os usuários cadastrados
	 * @return
	 */
	public List<Usuario> getUsuarios() {
		System.out.println("usuario");
		return usuarioDao.findAll();
	}
	
	
	public String novo() {
		return "usuario-formulario";
	}
}
