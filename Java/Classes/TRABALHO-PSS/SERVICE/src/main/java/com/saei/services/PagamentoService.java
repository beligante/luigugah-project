package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BasePagamentoPeer;
import com.saei.domain.commons.Pagamento;

public class PagamentoService {
	
	private static final Logger LOG = Logger.getLogger(PagamentoService.class);
	
	public int salvarPagamento(Pagamento pagamento){
		
		try{
			if(pagamento != null){
				BasePagamentoPeer.doInsert(pagamento);
				return pagamento.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo pagamento", e);
		}
		
		return -1;
	}
	
	public List<Pagamento> searchPagamento(Pagamento pagamento){
		try {
			if(pagamento != null){
				return BasePagamentoPeer.doSelect(pagamento);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o pagamento: \n" + pagamento.toString(), e);
		}
		return null;
	}
	
	public boolean removePagamento(Pagamento pagamento){
		try{
			if(pagamento != null){
				BasePagamentoPeer.doDelete(pagamento);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o pagamento de id[" + pagamento.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updatePagamento(Pagamento pagamento){
		try{
			if(pagamento != null){
				BasePagamentoPeer.doUpdate(pagamento);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o pagamento de id[" + pagamento.getId() + "]", e);
		}
		
		return false;
	}

}
