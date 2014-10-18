package com.saei.actions.usuario;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Usuario;

public class UsuarioSearchAction extends BaseAction{

	@Override
	public String execute() throws Exception {
		
		List<Usuario> usuarios = getAplicationEng().getUsuarioEng().getAllUsuarios();
		
		if(CollectionUtils.isEmpty(usuarios)){
			addActionMessage("Não exitesm usuarios cadastrados");
		}
		
		getServletRequest().setAttribute("usuarios", usuarios);
		
		return SUCCESS;
	}
}
