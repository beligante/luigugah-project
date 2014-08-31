package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseProdutoPeer;
import com.saei.domain.commons.Produto;

public class ProdutoService {

	private static final Logger LOG = Logger.getLogger(ProdutoService.class);
	
	public int salvarProduto(Produto produto){
		
		try{
			if(produto != null){
				BaseProdutoPeer.doInsert(produto);
				return produto.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo produto", e);
		}
		
		return -1;
	}
	
	public List<Produto> searchProduto(Produto produto){
		try {
			if(produto != null){
				return BaseProdutoPeer.doSelect(produto);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o produto: \n" + produto.toString(), e);
		}
		return null;
	}
	
	public boolean removeProduto(Produto produto){
		try{
			if(produto != null){
				BaseProdutoPeer.doDelete(produto);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o produto de id[" + produto.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateProduto(Produto produto){
		try{
			if(produto != null){
				BaseProdutoPeer.doUpdate(produto);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o produto de id[" + produto.getId() + "]", e);
		}
		
		return false;
	}
}
