package edu.fae.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;

import edu.fae.dao.DaoFactory;
import edu.fae.model.Usuario;

@SessionScoped
@ManagedBean(name = "usuarioMB")
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	private boolean skip;

	public String salvar() {
		DaoFactory.getUsuarioDao().save(usuario);
		usuario = new Usuario();

		return "";
	}

	public void resetar() {
		usuario = new Usuario();
	}

	public List<Usuario> findAll() {
		return DaoFactory.getUsuarioDao().findAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String onFlowProcess(FlowEvent event) {
		if (isSkip()) {
			setSkip(false);
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

}
