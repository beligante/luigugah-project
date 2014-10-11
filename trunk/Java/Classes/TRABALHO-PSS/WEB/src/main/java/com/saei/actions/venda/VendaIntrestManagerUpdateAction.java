package com.saei.actions.venda;

import java.util.List;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.InteresseVenda;
import com.saei.domain.commons.InteresseVendaHistorico;

public class VendaIntrestManagerUpdateAction extends BaseAction{
	
	private String id;
	private List<InteresseVendaHistorico> listInteresseVendHist;
	private InteresseVenda interesseVend;


	public String execute() {
		Integer id = null;
		id = Integer.parseInt(this.id);
		
		interesseVend = getAplicationEng().getInteresseVendaEng().getInteresseVendaById(id);
		listInteresseVendHist = getAplicationEng().getInteresseVendaEng().getInteresseVendaHistoricoByInteresseVendaId(id);
		
		request.setAttribute("interesseVenda", interesseVend);		
		
		return SUCCESS;
	}

	
	//-------GET AND SET-------
	
	public String getId() {
		return id;
	}

	public List<InteresseVendaHistorico> getListInteresseVendHist() {
		return listInteresseVendHist;
	}

	public void setListInteresseVendHist(
			List<InteresseVendaHistorico> listInteresseVendHist) {
		this.listInteresseVendHist = listInteresseVendHist;
	}

	public InteresseVenda getInteresseVend() {
		return interesseVend;
	}

	public void setInteresseVend(InteresseVenda interesseVend) {
		this.interesseVend = interesseVend;
	}

	public void setId(String id) {
		this.id = id;
	}
}
