package edu.fae.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person implements Model, Serializable{

	private static final long serialVersionUID = 3817830361676656197L;
	
	@Id
	@GeneratedValue
	@Column(name="idPerson")
	private Long id;
	
	@ManyToMany
	@JoinTable(name="company_partners", 
            joinColumns={@JoinColumn(name="idPerson")}, 
            inverseJoinColumns={@JoinColumn(name="idCompany")})
	private Set<Company> companies = new HashSet<Company>();

	private String fullname;
	private String password;

	private String mobile;

	private String telephone;
	private String email;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idAddress")
	private List<Address> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
