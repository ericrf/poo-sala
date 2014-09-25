package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.AnuncioDao;
import edu.fae.model.Anuncio;

@ViewScoped
@ManagedBean(name="anuncioListaController")
public class AnuncioListaController {
	private AnuncioDao anuncioDao = DaoFactory.getAnuncioDao();
	/**
	 * Armazena os anuncios mostrados na view
	 */
	private List<Anuncio> anuncios;
	
	/**
	 * Recebe o id do anuncio para ser exclu?do
	 */
	private Long id;
	
	/**
	 * M?todo que ? chamado quando a view ? aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void busca() {
		anuncios = anuncioDao.findNovos();
	}

	/**
	 * M?todo que exclui um anuncio
	 */
	public void excluir() {
		if(id!=null) {
			Anuncio anuncio = anuncioDao.findById(id);
			if(anuncio!=null) {
				anuncioDao.remove(anuncio);
				
				//Chama o buscaTodos para atualizar a lista
				busca();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Anuncio> getAnuncios() {
		return anuncios;
	}
}
