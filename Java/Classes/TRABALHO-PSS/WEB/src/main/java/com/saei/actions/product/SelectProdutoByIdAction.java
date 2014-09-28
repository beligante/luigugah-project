package com.saei.actions.product;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;
import com.saei.manager.ProdutoEng;

public class SelectProdutoByIdAction extends BaseAction {
	
	private static final String PRODUTO_ACTION = "product";
	
	@Override
	public String execute() throws Exception {
		
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			return PRODUTO_ACTION;
		}
		
		int intId = -1;
		try{intId = Integer.parseInt(id);}catch(Exception e){}
		
		if(intId < 0){return PRODUTO_ACTION;}
		
		Produto produto  = getAplicationEng().getProdutoEng().getProdutoById(intId);
		
		if(produto == null){return PRODUTO_ACTION;}
		
		request.setAttribute("produto", produto);
		
		return SUCCESS;
	}

}
