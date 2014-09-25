package edu.fae.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Company implements Model, Serializable {

	private static final long serialVersionUID = 6905062220237487453L;

	@Id
	@GeneratedValue
	@Column(name="idCompany")
	private Long id;

	@ManyToMany(mappedBy="companies", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Person> partners = new ArrayList<Person>();
	
	private String name;

	@OneToMany
	@JoinColumn(name="idAddress")
	private List<Address> address;

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public List<Person> getPartners() {
		return partners;
	}

	public void setPartners(List<Person> partners) {
		this.partners = partners;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
