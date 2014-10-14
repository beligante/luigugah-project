package com.saei.services;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BaseProdutoPeer;
import com.saei.domain.commons.Produto;

public class ProdutoService {

	private static final Logger LOG = Logger.getLogger(ProdutoService.class);
	
	public int salvarProduto(Produto produto){
		
		try{
			if(produto != null){
				produto.setDeletado(false);
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
			}else{
				return BaseProdutoPeer.doSelect(new Criteria());
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o produto: \n" + produto.toString(), e);
		}
		return null;
	}
	
	public Produto searchProdutoById(int id){
		try {
			Criteria c = new Criteria();
			c.add(BaseProdutoPeer.ID, id);
			List<Produto> produtos = BaseProdutoPeer.doSelect(c);
			if(CollectionUtils.isNotEmpty(produtos)){
				return produtos.get(0);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o produto de id[" + id + "]" , e);
		}
		return null;
	}
	
	public boolean removeProduto(Produto produto){
		try{
			if(produto != null){
				return removeProdutoById(produto.getId());
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o produto de id[" + produto.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean removeProdutoById(int id){
		try{
			Produto p = searchProdutoById(id);
			p.setDeletado(true);
			p.setNew(false);
			p.setModified(true);
			BaseProdutoPeer.doUpdate(p);
			return true;
			
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o produto de id[" + id + "]", e);
		}
		
		return false;
	}
	
	public boolean updateProduto(Produto produto){
		try{
			if(produto != null){
				produto.setNew(false);
				produto.setModified(true);
				BaseProdutoPeer.doUpdate(produto);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o produto de id[" + produto.getId() + "]", e);
		}
		
		return false;
	}
	
	public void changeProdutoSituacaoById(int id, String status){
		try{
			Produto produto = searchProdutoById(id);
			if(produto != null){
				produto.setNew(false);
				produto.setModified(true);
				produto.setSituacao(status);
				BaseProdutoPeer.doUpdate(produto);
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao alterar o status do produto de id[" + id + "]", e);
		}
	}
}
