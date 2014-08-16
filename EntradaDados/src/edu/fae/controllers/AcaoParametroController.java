package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean(name="acaoParametroController")
public class AcaoParametroController {
	private String nome;

	public String mostrar() {
		System.out.println(nome);
		return "acaoParametroMostrar";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
