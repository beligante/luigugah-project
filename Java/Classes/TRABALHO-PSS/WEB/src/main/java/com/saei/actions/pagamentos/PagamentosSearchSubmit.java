package com.saei.actions.pagamentos;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Usuario;


public class PagamentosSearchSubmit extends BaseAction{
	
	private static final long serialVersionUID = -3648584336739350889L;
	private static final String PAGAMENTOS_ACTION = "pagamentos";
	private String idUsuario;

	@Override
	public String execute() throws Exception {
		if(StringUtils.isEmpty(idUsuario)){ return PAGAMENTOS_ACTION;}
		int intIdUsuario = -1;
		Usuario usuario = null;
		try{
			intIdUsuario = Integer.parseInt(idUsuario);
			usuario = getAplicationEng().getUsuarioEng().getUsuarioById(intIdUsuario);
		}catch(Exception e){}
		if(intIdUsuario < 0 || usuario == null){return PAGAMENTOS_ACTION;}
		
		request.setAttribute("faturas",getAplicationEng()
												.getPagamentoEng()
												.getAllPagamentosByUsuario(intIdUsuario));
		
		
		return SUCCESS;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
