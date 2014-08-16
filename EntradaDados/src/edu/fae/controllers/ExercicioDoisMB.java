package edu.fae.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "exercicioDois")
public class ExercicioDoisMB {
	public double n1 = 0.0;
	public double n2 = 0.0;

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public void btnSomarListener() {
		showOperationResult("soma", (n1 + n2));
	}

	public void btnSubtrairListener() {
		showOperationResult("subtração", (n1 - n2));
	}

	public void btnMultiplicarListener() {
		showOperationResult("multiplicação", (n1 * n2));
	}

	public void btnDividirListener() {
		showOperationResult("divisão", (n1 / n2));
	}
	
	public void showOperationResult(String operacao, double resultado){
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage("Resultado da "+operacao+" entre "+n1+" e "+n2+": "+resultado));
	}
}
