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
import edu.fae.dao.UserDao;
import edu.fae.dao.hibernate.CityDaoHibernate;
import edu.fae.model.Address;
import edu.fae.model.City;
import edu.fae.model.User;

@ManagedBean
@ViewScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 4678939401185694748L;

	private UserDao dao;

	private Long id;
	private User user = new User();
	private List<User> users = new ArrayList<User>();
	private List<City> cities = new ArrayList<City>();
	private Address address;

	private boolean skip;

	@PostConstruct
	private void init() {
		dao = DaoFactory.getUserDao();

		String idParameter = null;
		Long id = null;
		users = findAll();
		cities = new CityDaoHibernate().findAll();
		idParameter = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (idParameter != null)
			id = Long.valueOf(idParameter);

		user = (id == null) ? new User() : dao.findOneById(id);
		address = (user.getAddresses() != null && user.getAddresses().size() > 0) ? user
				.getAddresses().get(0) : new Address();

		if (address.getCity() == null)
			address.setCity(new City());

		// Address a = new Address();
		// a.setStreet("rua blabla");
		// a.setPerson(user);
		// user.getAddresses().add(a);

	}

	public void remove() {
		user = dao.findOneById(id);
		dao.remove(user);
		user = new User();
		users = dao.findAll();
	}

	public void newo() {
		user = new User();
	}

	public List<User> findAll() {
		return dao.findAll();
	}

	public void save() {
		address.setPerson(user);
		user.getAddresses().add(address);
		dao.save(user);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage("Sucesso!", "id " + user.getId()));
		user = new User();
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
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

}