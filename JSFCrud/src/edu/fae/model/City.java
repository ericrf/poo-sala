package edu.fae.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class City implements Model, Serializable{
	
	private static final long serialVersionUID = -3201778333078903018L;

	@Id
	@GeneratedValue
	@Column(name="idCity")
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name="idState")
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public String toString() {
		return name;
	}

}
