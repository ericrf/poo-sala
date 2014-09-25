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
import org.primefaces.model.DualListModel;

import edu.fae.dao.CompanyDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.PersonDao;
import edu.fae.dao.hibernate.CityDaoHibernate;
import edu.fae.model.Address;
import edu.fae.model.City;
import edu.fae.model.Company;
import edu.fae.model.Person;
import edu.fae.util.DualListModelDiff;

@ManagedBean
@ViewScoped
public class CompanyController implements Serializable {
	private static final long serialVersionUID = 4678939401185694748L;

	private CompanyDao companyDao;
	
	private PersonDao personDao;

	private Long id;
	private Company company = new Company();
	private List<Company> companies = new ArrayList<Company>();
	private List<City> cities = new ArrayList<City>();
	private Address address;
	
	private boolean skip;
	
	@PostConstruct
	private void init() {
		companyDao = DaoFactory.getCompanyDao();
		personDao = DaoFactory.getPersonDao();
		
		String idParameter = null;
		Long id = null; 
		companies = findAll();
		cities = new CityDaoHibernate().findAll();
				
		idParameter = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(idParameter != null) id = Long.valueOf(idParameter);
		
		company = (id==null) ? new Company() : companyDao.findOneById(id);
		
		address = (company.getAddresses() != null && company.getAddresses().size() > 0) ? company
				.getAddresses().get(0) : new Address();

		if (address.getCity() == null)
			address.setCity(new City());
		
		
	}
	
	
	public void remove(){
		company = companyDao.findOneById(id);
		companyDao.remove(company);
		company = new Company();
		companies = companyDao.findAll();
	}
	
	public void newo() {
		company = new Company();
	}
	
	public List<Company> findAll(){
		return companyDao.findAll();
	}

	public void save() {
		companyDao.save(company);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso!",  "id " + company.getId()));
        company = new Company();
	}
	
	public DualListModel<Person> getCompanyPartners(){
		List<Person> source = personDao.findAll();
		List<Person> target = company.getPartners();
		
		return new DualListModelDiff<Person>(source, target);
	}
	public void setCompanyPartners(DualListModel<Person> partners) {
		
		List<Person> target = partners.getTarget();
		company.setPartners(target);
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company user) {
		this.company = user;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public void addAddress(Address na) {
		final Address a = na;
		company.getAddresses().add(a);

	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Address getAddress() {
		return address;
	}
	
	
}