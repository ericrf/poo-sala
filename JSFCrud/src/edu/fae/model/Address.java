package edu.fae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable, Model{

	private static final long serialVersionUID = -5126820131405380891L;

	@Id
	@GeneratedValue
	@Column(name="idAddress")
	private Long id;

	private String street;

	private String neiborhood;

	private String number;

	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;

	private Boolean main;
	
	@ManyToOne
	@JoinColumn(name="idPerson")
	private Person person;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeiborhood() {
		return neiborhood;
	}

	public void setNeiborhood(String neiborhood) {
		this.neiborhood = neiborhood;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Boolean getMain() {
		return main;
	}

	public void setMain(Boolean main) {
		this.main = main;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
