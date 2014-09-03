package com.saei.actions.product;

import com.saei.actions.BaseAction;

public class UpdateProdutoByIdAction extends BaseAction {
	
	private String id;
	
	@Override
	public String execute() throws Exception {
		
		Integer id = null;
		
		try{
			id = Integer.parseInt(this.id);
		}catch(Exception e){}
		
		if(id != null){
			getAplicationEng().getProdutoEng().deleteProductById(id);
		}
		
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
