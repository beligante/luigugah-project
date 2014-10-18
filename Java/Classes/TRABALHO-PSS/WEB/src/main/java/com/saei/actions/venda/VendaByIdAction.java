package com.saei.actions.venda;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoPagamento;

public class VendaByIdAction extends BaseAction{

	private static final String CATALOGO_ACTION = "catalogo";
	
	@Override
	public String execute() throws Exception {
		

		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			addActionError("Desculpe! Nenhum produto foi encontrado");
			return CATALOGO_ACTION;
		}
		
		String clientId = request.getParameter("clientId");
		int intClientId = -1;
		try{intClientId = Integer.parseInt(clientId);}catch(Exception e){}
		Usuario clienteRequest = null;
		if(StringUtils.isNotEmpty(clientId) && intClientId > 0){
			clienteRequest = getAplicationEng().getUsuarioEng().getUsuarioById(intClientId);
		}
		
		int intId = -1;
		try{intId = Integer.parseInt(id);}catch(Exception e){}
		if(intId < 0){
			addActionError("Desculpe! Nenhum produto foi encontrado");
			return CATALOGO_ACTION;
		}
		
		Produto produto  = getAplicationEng().getProdutoEng().getProdutoById(intId);
		if(produto == null){
			addActionError("Desculpe! Nenhum produto foi encontrado");
			return CATALOGO_ACTION;
		}
		
		request.setAttribute("produto", produto);
		
		List<Usuario> vendedores = getAplicationEng()
									.getUsuarioEng().getAllUsuarioVendedores();
		if(CollectionUtils.isEmpty(vendedores)){
			addActionError("Desculpe! Não existem vendedores cadastrados");
			return CATALOGO_ACTION;
		}
		request.setAttribute("vendedores", vendedores);

		List<Usuario> clientes = null;
		if(clienteRequest != null){
			clientes = new ArrayList<Usuario>();
			clientes.add(clienteRequest);
		}else{
			clientes = getAplicationEng()
				.getUsuarioEng().getAllUsuarios();
		}
		
		if(CollectionUtils.isEmpty(clientes)){
			addActionError("Desculpe! Não existem clientes cadastrados");
			return CATALOGO_ACTION;
		}
		request.setAttribute("clientes", clientes);

		TipoPagamento[] tipoPagamento = TipoPagamento.values();
		request.setAttribute("tiposPagamento", tipoPagamento);
		return SUCCESS;
	}
}
