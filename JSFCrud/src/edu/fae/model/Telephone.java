package edu.fae.model;

import java.io.Serializable;

public class Telephone implements Model, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1061647026401332572L;
	private Long id;
//	private static final long serialVersionUID = 3918341165874680015L;
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
