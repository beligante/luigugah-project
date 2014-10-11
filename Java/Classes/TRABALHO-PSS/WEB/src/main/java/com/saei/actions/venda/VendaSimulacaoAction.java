package com.saei.actions.venda;

import com.saei.actions.BaseAction;
import com.saei.constants.SessionConstants;

public class VendaSimulacaoAction extends BaseAction{


	private static final String CATALOGO_ACTION = "catalogo";
	
	@Override
	public String execute() throws Exception {
		
		Object obj = request.getSession().getAttribute(SessionConstants.SIMULACAO_KEY);
		if(obj == null){return CATALOGO_ACTION;}
		
		return SUCCESS;
	}
}
