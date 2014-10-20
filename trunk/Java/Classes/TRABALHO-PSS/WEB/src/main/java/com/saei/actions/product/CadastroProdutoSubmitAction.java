package com.saei.actions.product;

import java.math.BigDecimal;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;

public class CadastroProdutoSubmitAction extends BaseAction{
	
	private Produto produto;
	
	@Override
	public String execute() throws Exception {
		if(produto.getDimensoes().compareTo(BigDecimal.ZERO) <= 0){
			addActionError("Dimencao do produto nao pode ser menor ou igual a Zero");
			return SUCCESS;
		}
		
		if(produto.getPreco().compareTo(BigDecimal.ZERO) <= 0){
			addActionError("Valor do produto nao pode ser menor ou igual a Zero");
			return SUCCESS;
		}
		
		if(produto.getEndereco() == null){
			addActionError("Por favor preencha o campo endereco do produto");
			return SUCCESS;
		}
		
		if(produto.getBairro() == null){
			addActionError("Por favor preencha o campo bairro do produto");
			return SUCCESS;
		}
		
		if(produto.getCep() == null){
			addActionError("Por favor preencha o campo cep do produto");
			return SUCCESS;
		}
		
		getAplicationEng().getProdutoEng().registerProduct(getProduto());
		addActionSuccess("Produto Cadastrado Com Sucesso");
		return SUCCESS;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
