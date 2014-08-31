package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseCompraPeer;
import com.saei.domain.commons.Compra;

public class CompraService {
	
	private static final Logger LOG = Logger.getLogger(CompraService.class);
	
	public int salvarCompra(Compra compra){
		
		try{
			if(compra != null){
				BaseCompraPeer.doInsert(compra);
				return compra.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo compra", e);
		}
		
		return -1;
	}
	
	public List<Compra> searchCompra(Compra compra){
		try {
			if(compra != null){
				return BaseCompraPeer.doSelect(compra);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o compra: \n" + compra.toString(), e);
		}
		return null;
	}
	
	public boolean removeCompra(Compra compra){
		try{
			if(compra != null){
				BaseCompraPeer.doDelete(compra);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o compra de id[" + compra.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateCompra(Compra compra){
		try{
			if(compra != null){
				BaseCompraPeer.doUpdate(compra);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o compra de id[" + compra.getId() + "]", e);
		}
		
		return false;
	}
}
