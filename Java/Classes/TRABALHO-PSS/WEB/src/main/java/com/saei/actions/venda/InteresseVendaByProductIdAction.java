package com.saei.actions.venda;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.InteresseVenda;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;

public class InteresseVendaByProductIdAction extends BaseAction{

	private String productId;
	private String clientId;

	private static String PRODUCT_SEARCH = "product-search";
	
	@Override
	public String execute() throws Exception {
		
		Produto produto = null;
		
		try{
			produto = getAplicationEng().getProdutoEng().getProdutoById(Integer.parseInt(productId));
		}catch(Exception e){
			LOG.error("ocorreu um erro ao inserir um interesse", e);
		}
		
		if(produto == null){
			addActionError("Houve um problema ao registrar seu interesse em comprar");
			response.sendRedirect("/SAEI");
			return null;
		}
		
		Usuario usuario = null;
		
		try{
			usuario = getAplicationEng().getUsuarioEng().getUsuarioById(Integer.parseInt(clientId));
		}catch(Exception e){
			LOG.error("ocorreu um erro ao inserir um interesse", e);
		}
		
		if(usuario != null){
			InteresseVenda iv = new InteresseVenda();
			iv.setClienteId(usuario.getId());
			iv.setProdutoId(produto.getId());
			getAplicationEng().getInteresseVendaEng().registerInteresseVenda(iv);
			addActionSuccess("Interesse registrado com sucesso!");
		}else{
			addActionError("Houve um problema ao registrar seu interesse em comprar");
		}
		
		request.setAttribute("id",productId);
		return SUCCESS;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
