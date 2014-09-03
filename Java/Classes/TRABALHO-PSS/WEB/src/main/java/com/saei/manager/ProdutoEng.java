package com.saei.manager;

import java.util.Date;
import java.util.List;

import com.saei.domain.commons.Produto;
import com.saei.services.ProdutoService;

public class ProdutoEng {

	private static ProdutoService PRODUTO_SERVICE;
	
	static {
		PRODUTO_SERVICE = new ProdutoService();
	}
	
	public Produto registerProduct(Produto produto){
		produto.setDataCadastro(new Date());
		PRODUTO_SERVICE.salvarProduto(produto);
		
		return produto;
	}
	
	public List<Produto> getAllProdutos(){
		return PRODUTO_SERVICE.searchProduto(null);
	}
	
	public void deleteProductByProduct(Produto produto){
		if(produto != null){
			deleteProductById(produto.getId());
		}
	}
	
	public void deleteProductById(int id){
		Produto prod = new Produto();
		prod.setId(id);
		PRODUTO_SERVICE.removeProduto(prod);
	}
}
