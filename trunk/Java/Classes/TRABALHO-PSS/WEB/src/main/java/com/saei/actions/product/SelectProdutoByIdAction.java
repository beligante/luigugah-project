package com.saei.actions.product;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;
import com.saei.manager.ProdutoEng;

public class SelectProdutoByIdAction extends BaseAction {
	
	private static final String PRODUTO_ACTION = "product";
	
	private String id;
	
	@Override
	public String execute() throws Exception {
		
		if(StringUtils.isEmpty(id))
		{
			if(request.getAttribute("id") == null){
				return PRODUTO_ACTION;
			}
			
			setId(request.getAttribute("id").toString());
		}
		
		int intId = -1;
		try{intId = Integer.parseInt(id);}catch(Exception e){}
		
		if(intId < 0){return PRODUTO_ACTION;}
		
		Produto produto  = getAplicationEng().getProdutoEng().getProdutoById(intId);
		
		if(produto == null){return PRODUTO_ACTION;}
		
		request.setAttribute("produto", produto);
		
		request.setAttribute("isExisteInteresse", getAplicationEng().getInteresseVendaEng().existeInteresseByUserAndProduct(1, produto.getId()));
		
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
