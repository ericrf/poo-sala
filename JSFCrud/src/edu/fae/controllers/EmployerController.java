package edu.fae.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.EmployerDao;
import edu.fae.dao.hibernate.CityDaoHibernate;
import edu.fae.dao.hibernate.CompanyDaoHibernate;
import edu.fae.model.Address;
import edu.fae.model.City;
import edu.fae.model.Company;
import edu.fae.model.Employer;

@ManagedBean
@ViewScoped
public class EmployerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7450461097463680963L;

	private EmployerDao dao;

	private Long id;
	private Employer user = new Employer();
	private List<Employer> users = new ArrayList<Employer>();
	private List<Company> companies = new ArrayList<Company>();
	private List<City> cities = new ArrayList<City>();
	private Address address;

	private boolean skip;

	@PostConstruct
	private void init() {
		dao = DaoFactory.getEmployerDao();

		String idParameter = null;
		Long id = null;
		users = findAll();
		cities = new CityDaoHibernate().findAll();
		idParameter = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (idParameter != null)
			id = Long.valueOf(idParameter);

		user = (id == null) ? new Employer() : dao.findOneById(id);
		address = (user.getAddresses() != null && user.getAddresses().size() > 0) ? user
				.getAddresses().get(0) : new Address();

		if (address.getCity() == null)
			address.setCity(new City());
		
		companies = new CompanyDaoHibernate().findAll();

		// Address a = new Address();
		// a.setStreet("rua blabla");
		// a.setPerson(user);
		// user.getAddresses().add(a);

	}

	public void remove() {
		user = dao.findOneById(id);
		dao.remove(user);
		user = new Employer();
		users = dao.findAll();
	}

	public void newo() {
		user = new Employer();
	}

	public List<Employer> findAll() {
		return dao.findAll();
	}

	public void save() {
		address.setPerson(user);
		user.getAddresses().add(address);
		dao.save(user);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage("Sucesso!", "id " + user.getId()));
		user = new Employer();
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public Employer getUser() {
		return user;
	}

	public void setUser(Employer user) {
		this.user = user;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public List<Employer> getUsers() {
		return users;
	}

	public void setUsers(List<Employer> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addAddress(Address na) {
		final Address a = na;
		user.getAddresses().add(a);

	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	

}