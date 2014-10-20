package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseModalidadeNegociacaoPeer;
import com.saei.domain.commons.ModalidadeNegociacao;
import com.saei.domain.commons.Produto;

public class ModalidadeNegociacaoService {

private static final Logger LOG = Logger.getLogger(ModalidadeNegociacaoService.class);
	
	public int salvarModalidadeNegociacao(ModalidadeNegociacao modalidadeNegociacao){
		
		try{
			if(modalidadeNegociacao != null){
				BaseModalidadeNegociacaoPeer.doInsert(modalidadeNegociacao);
				return modalidadeNegociacao.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar uma nova ModalidadeNegociacao", e);
		}
		
		return -1;
	}
	
	public List<Produto> searchByModalidadeNegociacao(ModalidadeNegociacao modalidadeNegociacao){
		try {
			if(modalidadeNegociacao != null){
				return BaseModalidadeNegociacaoPeer.doSelect(modalidadeNegociacao);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar a ModalidadeNegociacao", e);
		}
		return null;
	}
	
	public boolean removeModalidadeNegociacao(ModalidadeNegociacao modalidadeNegociacao){
		try{
			if(modalidadeNegociacao != null){
				BaseModalidadeNegociacaoPeer.doDelete(modalidadeNegociacao);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover a ModalidadeNegociacao de id[" + modalidadeNegociacao.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateModalidadeNegociacao(ModalidadeNegociacao modalidadeNegociacao){
		try{
			if(modalidadeNegociacao != null){
				BaseModalidadeNegociacaoPeer.doUpdate(modalidadeNegociacao);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover a ModalidadeNegociacao de id[" + modalidadeNegociacao.getId() + "]", e);
		}
		
		return false;
	}
}
