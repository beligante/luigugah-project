package com.saei.actions.pagamentos;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Usuario;

public class PagamentosSearch extends BaseAction{
	
	@Override
	public String execute() throws Exception {
		
		List<Usuario> usuarios = getAplicationEng().getUsuarioEng().getAllUsuarios();
		
		if(CollectionUtils.isNotEmpty(usuarios)){
			addActionMessage("Não existem usuarios cadastrados!");
		}
		
		request.setAttribute("usuarios", getAplicationEng().getUsuarioEng().getAllUsuarios());		
		return SUCCESS;
	}
}
