package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.VendedorDao;
import edu.fae.model.Vendedor;

@ViewScoped
@ManagedBean(name="vendedorListaController")
public class VendedorListaController {
	private VendedorDao vendedorDao = DaoFactory.getVendedorDao();
	/**
	 * Armazena os vendedors mostrados na view
	 */
	private List<Vendedor> vendedores;
	
	/**
	 * Recebe o id do vendedor para ser exclu?do
	 */
	private Long id;
	
	/**
	 * M?todo que ? chamado quando a view ? aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		vendedores = vendedorDao.findAll();
	}

	/**
	 * M?todo que exclui um vendedor
	 */
	public void excluir() {
		if(id!=null) {
			Vendedor vendedor = vendedorDao.findById(id);
			if(vendedor!=null) {
				vendedorDao.remove(vendedor);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Vendedor> getVendedores() {
		return vendedores;
	}
}
