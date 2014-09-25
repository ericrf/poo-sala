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
import edu.fae.dao.PersonDao;
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
	
	private boolean skip;
	
	@PostConstruct
	private void init() {
		String idParameter = null;
		Long id = null; 
		companies = findAll();
				
		idParameter = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(idParameter != null) id = Long.valueOf(idParameter);
		if(id==null) {
			company = new Company();
		}else{
			company = companyDao.findOneById(id);
		}
		
		
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
		company.setPartners(partners.getTarget());
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
}