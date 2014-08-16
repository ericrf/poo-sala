package edu.fae.controllers;

import java.text.DecimalFormat;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "exercicioUm")
public class ExercicioUmMB {
	public String sexo;
	public double altura;
	
	public void btnCalcularPesoIdealListener(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("Seu peso ideal é: " + getPesoIdeal()));
	}
	
	public String getPesoIdeal(){
		double pesoIdeal = calcularPesoIdeal();
		return formatarPesoIdeal(pesoIdeal);
	}
	public String formatarPesoIdeal(double pesoIdeal){		
		DecimalFormat format = new DecimalFormat("#0.00");		
		return format.format(pesoIdeal);
	}
	public double calcularPesoIdeal() {
		double pesoIdeal = 0;
		switch (sexo) {
		case "m":
			pesoIdeal = (72.7 * altura) - 58;
			break;
		case "f":
			pesoIdeal = (62.1 * altura) - 44;
			break;
		}
		
		return pesoIdeal;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
