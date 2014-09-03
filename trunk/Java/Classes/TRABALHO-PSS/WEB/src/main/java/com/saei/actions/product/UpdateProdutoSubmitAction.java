package com.saei.actions.product;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;

public class UpdateProdutoSubmitAction extends BaseAction{

	private Produto produto;
	
	@Override
	public String execute() throws Exception {
		getAplicationEng().getProdutoEng().updateProdutoByProduto(produto);		
		return SUCCESS;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
