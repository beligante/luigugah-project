package com.saei.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.saei.domain.Simulacao;
import com.saei.domain.commons.Produto;
import com.saei.domain.enums.SituacaoProduto;
import com.saei.services.ProdutoService;

public class ProdutoEng {

	private static ProdutoService PRODUTO_SERVICE;
	
	static {
		PRODUTO_SERVICE = new ProdutoService();
	}
	
	public Produto registerProduct(Produto produto){
		produto.setDataCadastro(new Date());
		if(produto.getPreco() == null){	produto.setPreco(BigDecimal.ZERO);}
		produto.setSituacao(SituacaoProduto.DISPONIVEL.name());
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
	
	public Produto getProdutoById(int id){
		return PRODUTO_SERVICE.searchProdutoById(id);
	}
	
	public void updateProdutoByProduto(Produto produto){
		produto.setSituacao(SituacaoProduto.DISPONIVEL.name());
		PRODUTO_SERVICE.updateProduto(produto);
	}
}
