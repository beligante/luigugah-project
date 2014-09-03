package com.saei.actions.product;

import java.util.ArrayList;
import java.util.List;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Produto;
import com.saei.domain.enums.TipoProduto;

public class UpdateProdutoByIdAction extends BaseAction {
	
	private String id;
	private Produto produto;
	
	@Override
	public String execute() throws Exception {
		
		Integer id = null;
		
		try{
			id = Integer.parseInt(this.id);
		}catch(Exception e){}
		
		if(id != null){
			produto = getAplicationEng().getProdutoEng().getProdutoById(id);
		}
		
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<String> getEstados(){
		List<String> estados = new ArrayList<String>();
		estados.add("PR");
		return estados;
	}
	
	public List<String> getCidades(){
		List<String> cidades = new ArrayList<String>();
		cidades.add("Maringa");
		return cidades;
	}
	
	public List<String> getTiposProduto(){
		List<String> tipoProduto = new ArrayList<String>();
		for(TipoProduto tipo : TipoProduto.values()){
			tipoProduto.add(tipo.getLabel());
		}
		return tipoProduto;
	}
}
