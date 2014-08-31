package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseFaturaPagamentoPeer;
import com.saei.domain.commons.FaturaPagamento;

public class FaturaPagamentoService {
	
private static final Logger LOG = Logger.getLogger(FaturaPagamentoService.class);
	
	public int salvarFaturaPagamento(FaturaPagamento faturaPagamento){
		
		try{
			if(faturaPagamento != null){
				BaseFaturaPagamentoPeer.doInsert(faturaPagamento);
				return faturaPagamento.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo faturaPagamento", e);
		}
		
		return -1;
	}
	
	public List<FaturaPagamento> searchFaturaFaturaPagamento(FaturaPagamento faturaPagamento){
		try {
			if(faturaPagamento != null){
				return BaseFaturaPagamentoPeer.doSelect(faturaPagamento);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o faturaPagamento: \n" + faturaPagamento.toString(), e);
		}
		return null;
	}
	
	public boolean removeFaturaFaturaPagamento(FaturaPagamento faturaPagamento){
		try{
			if(faturaPagamento != null){
				BaseFaturaPagamentoPeer.doDelete(faturaPagamento);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o faturaPagamento de id[" + faturaPagamento.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateFaturaFaturaPagamento(FaturaPagamento faturaPagamento){
		try{
			if(faturaPagamento != null){
				BaseFaturaPagamentoPeer.doUpdate(faturaPagamento);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o faturaPagamento de id[" + faturaPagamento.getId() + "]", e);
		}
		
		return false;
	}

}
