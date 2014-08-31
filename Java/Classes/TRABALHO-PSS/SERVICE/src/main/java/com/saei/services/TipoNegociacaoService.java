package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseTipoNegociacaoPeer;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.TipoNegociacao;

public class TipoNegociacaoService {

private static final Logger LOG = Logger.getLogger(TipoNegociacaoService.class);
	
	public int salvarTipoNegociacao(TipoNegociacao tipoNegociacao){
		
		try{
			if(tipoNegociacao != null){
				BaseTipoNegociacaoPeer.doInsert(tipoNegociacao);
				return tipoNegociacao.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo tipoNegociacao", e);
		}
		
		return -1;
	}
	
	public List<Produto> searchByTipoNegociacao(TipoNegociacao tipoNegociacao){
		try {
			if(tipoNegociacao != null){
				return BaseTipoNegociacaoPeer.doSelect(tipoNegociacao);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o tipoNegociacao: \n" + tipoNegociacao.toString(), e);
		}
		return null;
	}
	
	public boolean removeTipoNegociacao(TipoNegociacao tipoNegociacao){
		try{
			if(tipoNegociacao != null){
				BaseTipoNegociacaoPeer.doDelete(tipoNegociacao);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o tipoNegociacao de id[" + tipoNegociacao.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateTipoNegociacao(TipoNegociacao tipoNegociacao){
		try{
			if(tipoNegociacao != null){
				BaseTipoNegociacaoPeer.doUpdate(tipoNegociacao);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o tipoNegociacao de id[" + tipoNegociacao.getId() + "]", e);
		}
		
		return false;
	}
	
}
