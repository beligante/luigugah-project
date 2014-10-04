package com.saei.manager;

import java.util.Date;
import java.util.List;

import com.saei.domain.commons.InteresseVenda;
import com.saei.services.InteresseVendaService;

public class InteresseVendaEng {

private static InteresseVendaService INTERESSE_SERVICE;
	
	static {
		INTERESSE_SERVICE = new InteresseVendaService();
	}
	
	public InteresseVenda registerInteresseVenda(InteresseVenda interesseVend){
		interesseVend.setDataCadastro(new Date());
		INTERESSE_SERVICE.salvarInteresseVenda(interesseVend);
		
		return interesseVend;
	}
	
	public List<InteresseVenda> getAllInteresseVendas(){
		return INTERESSE_SERVICE.searchInteresseVenda(null);
	}
	
	public void deleteInteresseVendaByInteresseVenda(InteresseVenda interesseVend){
		if(interesseVend != null){
			deleteInteresseVendaById(interesseVend.getId());
		}
	}
	
	public void deleteInteresseVendaById(int id){
		InteresseVenda interesseVend = new InteresseVenda();
		interesseVend.setId(id);
		INTERESSE_SERVICE.removeInteresseVenda(interesseVend);
	}
	
	public InteresseVenda getInteresseVendaById(int id){
		return INTERESSE_SERVICE.searchInteresseVendaById(id);
	}
	
	public void updateInteresseVendaByInteresseVenda(InteresseVenda interesseVend){
		INTERESSE_SERVICE.updateInteresseVenda(interesseVend);
	}
	
}
