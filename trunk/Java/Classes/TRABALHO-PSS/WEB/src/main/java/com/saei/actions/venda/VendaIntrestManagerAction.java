package com.saei.actions.venda;

import com.saei.actions.BaseAction;

public class VendaIntrestManagerAction extends BaseAction{
	
	public String execute() {
		
		request.setAttribute("isInteresseVendaPage", true);
		
		request.setAttribute("interessesVenda", 
				getAplicationEng().getInteresseVendaEng().getAllInteresseVendas());
		
		return SUCCESS;
	}
}
