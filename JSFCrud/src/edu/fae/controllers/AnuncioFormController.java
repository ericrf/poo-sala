package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import edu.fae.dao.AnuncioDao;
import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.VendedorDao;
import edu.fae.model.Anuncio;
import edu.fae.model.Categoria;
import edu.fae.model.Vendedor;
import edu.fae.util.DualListModelDiff;

@ViewScoped
@ManagedBean(name="anuncioFormController")
public class AnuncioFormController {
	private AnuncioDao anuncioDao = DaoFactory.getAnuncioDao();
	private VendedorDao vendedorDao = DaoFactory.getVendedorDao();

	/**
	 * Objeto anuncio que ? editado no formul?rio
	 */
	private Anuncio anuncio;

	/**
	 * Este m?todo ? chamado quando a p?gina do formul?rio ? aberta
	 */
	@PostConstruct
	public void iniciar() {
		//Pegando o par?metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id est? null, abrimos o formul?rio para inser??o
			anuncio = new Anuncio();
		}else{//Quando o id ? passado como par?metro abrimos o formul?rio para edi??o
			anuncio = anuncioDao.findById(new Long(id));
		}
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	
	public void salvar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		

		//Chama o anuncioDao para salvar o objeto Anuncio
		anuncioDao.save(anuncio);
		
		//Mandando uma mensagem para a tela
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Anuncio salvo com sucesso!", null)
		);
	}
	
	
	public void comprar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		anuncio.setSituacao("Comprado");
		//Chama o anuncioDao para salvar o objeto Anuncio
		anuncioDao.save(anuncio);
		
		//Mandando uma mensagem para a tela
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Anuncio comprado com sucesso!", null)
		);
	}	

	public List<Vendedor> getVendedores() {
		return vendedorDao.findAll();
	}
	
	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();

	public DualListModel<Categoria> getAnuncioCategorias() {
		return new DualListModelDiff<Categoria>(categoriaDao.findAll(), getAnuncio().getCategorias());
	}	
	public void setAnuncioCategorias(DualListModel<Categoria> categorias) {
		getAnuncio().setCategorias(categorias.getTarget());
	}	


}
