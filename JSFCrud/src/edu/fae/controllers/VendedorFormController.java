package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.VendedorDao;
import edu.fae.dao.DaoFactory;
import edu.fae.model.Vendedor;

@ViewScoped
@ManagedBean(name="vendedorFormController")
public class VendedorFormController {
	private VendedorDao vendedorDao = DaoFactory.getVendedorDao();

	/**
	 * Objeto vendedor que ? editado no formul?rio
	 */
	private Vendedor vendedor;

	/**
	 * Este m?todo ? chamado quando a p?gina do formul?rio ? aberta
	 */
	@PostConstruct
	public void iniciar() {
		//Pegando o par?metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id est? null, abrimos o formul?rio para inser??o
			vendedor = new Vendedor();
		}else{//Quando o id ? passado como par?metro abrimos o formul?rio para edi??o
			vendedor = vendedorDao.findById(new Long(id));
		}
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void salvar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		

		//Chama o vendedorDao para salvar o objeto Vendedor
		vendedorDao.save(vendedor);
		
		//Mandando uma mensagem para a tela
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Vendedor salvo com sucesso!", null)
		);
	}
	

}
