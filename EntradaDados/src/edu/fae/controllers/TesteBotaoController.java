package edu.fae.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@RequestScoped
@ManagedBean(name="testeBotaoController")
public class TesteBotaoController {
	
	public void botao1Click() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("Botao 1 clicado"));
	}
	
	public void botao2Click() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("Botao 2 clicado"));		
	}	
	
}
