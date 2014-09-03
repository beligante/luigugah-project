package com.saei.actions.usuario;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Usuario;

public class CadastroUsuarioSubmitAction  extends BaseAction {

	private Usuario usuario;
	
	@Override
	public String execute() throws Exception {
		
		getAplicationEng().getUsuarioEng().registerUsuariow(usuario);
		return SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
