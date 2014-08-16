package edu.fae.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.model.Usuario;


@RequestScoped
@ManagedBean(name="usuarioMB")
public class UsuarioMB {
	
	private Usuario usuario = new Usuario();
	
	public void salvar(){
		DaoFactory.getUsuarioDao().save(usuario);
		usuario = new Usuario();
	}
	
	public List<Usuario> findAll(){
		return DaoFactory.getUsuarioDao().findAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
