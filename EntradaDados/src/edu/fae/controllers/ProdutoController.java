package edu.fae.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import edu.fae.model.Produto;

@RequestScoped
@ManagedBean(name="produtoController")
public class ProdutoController {
	private Produto produto;

	
	public String novo() {
		produto = new Produto();
		//Valores padr�o que ser�o enviados para o formul�rio
		produto.setNome("Novo produto");
		produto.setMarca("HP");
		
		return "produtoFormulario";
	}
	
	public String salvar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		if(produto.getNome()==null || produto.getNome().length() ==0) {
			//Mandando uma mensagem de erro para a tela
			ctx.addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe corretamente o nome!", null)
			);
		}else{
		
			//Imprimindo as informa��es que foram digitadas pelo usu�rio
			//no formul�rio
			System.out.println(produto.getNome());
			System.out.println(produto.getMarca());
			System.out.println(produto.getDescricao());
			System.out.println(produto.getCor());
			System.out.println(produto.getData());
			System.out.println(produto.getQtdeEstoque());
			
			
			//Mandando uma mensagem para a tela
			ctx.addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", null)
			);
		}
		
		return "produtoFormulario";
	}
	
	
	public String mostrar() {
		produto = new Produto();
		produto.setNome("Notebook");
		produto.setMarca("HP");
		return "produtoMostrar";
	}
	
	
	public Produto getProduto() {
		if(produto==null)
			produto = new Produto();		
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
