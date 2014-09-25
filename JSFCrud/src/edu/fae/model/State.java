package edu.fae.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State implements Model, Serializable{
	
	private static final long serialVersionUID = 3918341165874680015L;

	@Id
	@GeneratedValue
	@Column(name="idState")
	private Long id;

	private String name;

	private String code;
	
	@OneToMany(mappedBy="state", fetch = FetchType.EAGER)
	private List<City> cities = new ArrayList<City>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
}
