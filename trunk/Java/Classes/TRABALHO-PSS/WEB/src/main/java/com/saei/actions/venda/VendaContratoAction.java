package com.saei.actions.venda;

import com.saei.actions.BaseAction;
import com.saei.constants.SessionConstants;
import com.saei.domain.commons.Usuario;

public class VendaContratoAction extends BaseAction {
	

	private static final String CATALOGO_ACTION = "catalogo";
	
	@Override
	public String execute() throws Exception {
		try{
			Usuario cliente = (Usuario) request.getSession().getAttribute(SessionConstants.CHECKOUT_CLIENT_KEY);
			request.setAttribute("cliente", cliente);
			if(cliente  == null){
				throw new Exception();
			}
		}catch(Exception e){
			addActionError("Desculpe! Ocorreu um erro inesperado no processo de compra.");
			request.getSession().invalidate();
			return CATALOGO_ACTION;
		}
		return SUCCESS;
	}
}
