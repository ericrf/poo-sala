package edu.fae.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean(name="acaoController")
public class AcaoController {
	
	public String mostrar() {
		return "acaoMostrar";
	}
	
}
