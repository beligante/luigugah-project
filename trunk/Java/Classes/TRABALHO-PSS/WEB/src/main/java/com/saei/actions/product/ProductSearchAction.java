package com.saei.actions.product;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;

public class ProductSearchAction extends BaseAction {
	
	@Override
	public String execute() throws Exception {
	
		List<Produto> produtos = getAplicationEng().getProdutoEng().getAllProdutos();
		
		if(CollectionUtils.isEmpty(produtos)){
			addActionMessage("Nao Existem produtos cadastrados!");
		}
		int contador = 0;
		for(Produto p : produtos){
			if(p.getDeletado()){
				contador++; 
			}
		}
		
		if(contador == produtos.size()){
			addActionMessage("Nao Existem produtos cadastrados!");
		}
		
		request.setAttribute("produtos", produtos);
		
		return SUCCESS;
	}
}
