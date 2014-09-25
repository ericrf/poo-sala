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
	 * Objeto categoria que é editado no formulário
	 */
	private Categoria categoria;

	/**
	 * Este método é chamado quando a página do formulário é aberta
	 */
	@PostConstruct
	public void iniciar() {
		//Pegando o parâmetro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id está null, abrimos o formulário para inserção
			categoria = new Categoria();
		}else{//Quando o id é passado como parâmetro abrimos o formulário para edição
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
