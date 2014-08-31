package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseHistoricoCompraPeer;
import com.saei.domain.commons.HistoricoCompra;

public class HistoricoCompraService {
	
	private static final Logger LOG = Logger.getLogger(HistoricoCompraService.class);
	
	public int salvarHistoricoCompra(HistoricoCompra historicoCompra){
		
		try{
			if(historicoCompra != null){
				BaseHistoricoCompraPeer.doInsert(historicoCompra);
				return historicoCompra.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo historicoCompra", e);
		}
		
		return -1;
	}
	
	public List<HistoricoCompra> searchHistoricoCompra(HistoricoCompra historicoCompra){
		try {
			if(historicoCompra != null){
				return BaseHistoricoCompraPeer.doSelect(historicoCompra);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o historicoCompra: \n" + historicoCompra.toString(), e);
		}
		return null;
	}
	
	public boolean removeHistoricoCompra(HistoricoCompra historicoCompra){
		try{
			if(historicoCompra != null){
				BaseHistoricoCompraPeer.doDelete(historicoCompra);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o historicoCompra de id[" + historicoCompra.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateHistoricoCompra(HistoricoCompra historicoCompra){
		try{
			if(historicoCompra != null){
				BaseHistoricoCompraPeer.doUpdate(historicoCompra);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o historicoCompra de id[" + historicoCompra.getId() + "]", e);
		}
		
		return false;
	}
}
