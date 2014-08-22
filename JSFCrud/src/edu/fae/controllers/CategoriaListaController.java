package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.CategoriaDao;
import edu.fae.model.Categoria;

@ViewScoped
@ManagedBean(name="categoriaListaController")
public class CategoriaListaController {
	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();
	/**
	 * Armazena os categorias mostrados na view
	 */
	private List<Categoria> categorias;
	
	/**
	 * Recebe o id do categoria para ser excluído
	 */
	private Long id;
	
	/**
	 * Método que é chamado quando a view é aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		categorias = categoriaDao.findAll();
	}

	/**
	 * Método que exclui um categoria
	 */
	public void excluir() {
		if(id!=null) {
			Categoria categoria = categoriaDao.findById(id);
			if(categoria!=null) {
				categoriaDao.remove(categoria);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
}
