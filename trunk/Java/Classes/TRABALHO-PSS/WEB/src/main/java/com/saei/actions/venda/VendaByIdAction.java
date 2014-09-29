package com.saei.actions.venda;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;

public class VendaByIdAction extends BaseAction{

	private static final String CATALOGO_ACTION = "catalogo";
	
	@Override
	public String execute() throws Exception {
		

		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			return CATALOGO_ACTION;
		}
		
		int intId = -1;
		try{intId = Integer.parseInt(id);}catch(Exception e){}
		if(intId < 0){return CATALOGO_ACTION;}
		
		Produto produto  = getAplicationEng().getProdutoEng().getProdutoById(intId);
		if(produto == null){return CATALOGO_ACTION;}
		
		request.setAttribute("produto", produto);
		
		List<Usuario> vendedores = getAplicationEng()
									.getUsuarioEng().getAllUsuarioVendedores();
		if(CollectionUtils.isEmpty(vendedores)){return CATALOGO_ACTION;}
		request.setAttribute("vendedores", vendedores);

		List<Usuario> clientes = getAplicationEng()
				.getUsuarioEng().getAllUsuarios();
		if(CollectionUtils.isEmpty(clientes)){return CATALOGO_ACTION;}
		request.setAttribute("clientes", clientes);

		
		return SUCCESS;
	}
}
