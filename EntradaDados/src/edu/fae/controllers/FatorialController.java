package edu.fae.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@RequestScoped
@ManagedBean(name="fatorialController")
public class FatorialController {
	private int numero;

	public void calcularFatorial() {
		int fatorial = fatorial(this.numero);
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("O fatorial é: " + fatorial));
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	private int fatorial(int x) {
		if(x<=1) {
			return 1;
		}
		return x * fatorial(x - 1);
	}
	
}
