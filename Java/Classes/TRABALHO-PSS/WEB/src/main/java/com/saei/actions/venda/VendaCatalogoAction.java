package com.saei.actions.venda;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;

public class VendaCatalogoAction extends BaseAction  {
	// all struts logic here 
	@Override
	public String execute() {
		
		request.setAttribute("isVendaPage", true);
		
		List<Produto> produtos = getAplicationEng().getProdutoEng().getAllProdutos();
		
		if(CollectionUtils.isEmpty(produtos)){
			addActionMessage("Não Existem produtos disponiveis para venda");
		}
		
		int contador = 0;
		for(Produto p : produtos){
			if(p.getDeletado()){
				contador++;
			}
		}
		
		if(contador == produtos.size()){
			addActionMessage("Não Existem produtos disponiveis para venda");
		}
		
		request.setAttribute("produtos", produtos);
		
		return SUCCESS;

	}
}
