package com.saei.actions.pagamentos;

import com.saei.actions.BaseAction;

public class PagamentosSearch extends BaseAction{
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("usuarios", getAplicationEng().getUsuarioEng().getAllUsuarios());		
		return SUCCESS;
	}
}
