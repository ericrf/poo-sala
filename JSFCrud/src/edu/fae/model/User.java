package edu.fae.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class User extends Person implements Model, Serializable {

	private static final long serialVersionUID = 4202708003881303885L;
}
