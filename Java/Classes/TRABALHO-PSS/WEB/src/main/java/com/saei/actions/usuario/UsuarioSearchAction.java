package com.saei.actions.usuario;

import com.saei.actions.BaseAction;

public class UsuarioSearchAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		
		getServletRequest().setAttribute("usuarios", 
				getAplicationEng().getUsuarioEng().getAllUsuarios());
		
		return SUCCESS;
	}
}
