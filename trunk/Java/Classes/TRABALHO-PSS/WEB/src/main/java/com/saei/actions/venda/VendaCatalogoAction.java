package com.saei.actions.venda;

import com.saei.actions.BaseAction;

public class VendaCatalogoAction extends BaseAction  {
	// all struts logic here 
	public String execute() {
		
		request.setAttribute("isVendaPage", true);
		
		request.setAttribute("produtos", 
				getAplicationEng().getProdutoEng().getAllProdutos());
		
		return SUCCESS;

	}
}
