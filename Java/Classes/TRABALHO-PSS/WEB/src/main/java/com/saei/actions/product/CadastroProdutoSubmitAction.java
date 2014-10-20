package com.saei.actions.product;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;

public class CadastroProdutoSubmitAction extends BaseAction{
	
	private Produto produto;
	
	@Override
	public String execute() throws Exception {
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
