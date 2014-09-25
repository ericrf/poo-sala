package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.CategoriaDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Categoria;

@ViewScoped
@ManagedBean(name="categoriaFormController")
public class CategoriaFormController {
	private CategoriaDao categoriaDao = DaoFactory.getCategoriaDao();

	/**
	 * Objeto categoria que � editado no formul�rio
	 */
	private Categoria categoria;

	/**
	 * Este m�todo � chamado quando a p�gina do formul�rio � aberta
	 */
	@PostConstruct
	public void iniciar() {
		//Pegando o par�metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id est� null, abrimos o formul�rio para inser��o
			categoria = new Categoria();
		}else{//Quando o id � passado como par�metro abrimos o formul�rio para edi��o
			categoria = categoriaDao.findById(new Long(id));
		}
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void salvar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		

		//Chama o categoriaDao para salvar o objeto Categoria
		categoriaDao.save(categoria);
		
		//Mandando uma mensagem para a tela
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria salvo com sucesso!", null)
		);
	}
	

}
