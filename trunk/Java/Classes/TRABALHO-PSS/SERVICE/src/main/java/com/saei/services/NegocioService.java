package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseNegocioPeer;
import com.saei.domain.commons.Negocio;

public class NegocioService {
	
	private static final Logger LOG = Logger.getLogger(NegocioService.class);
	
	public int salvarNegocio(Negocio negocio){
		
		try{
			if(negocio != null){
				BaseNegocioPeer.doInsert(negocio);
				return negocio.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo negocio", e);
		}
		
		return -1;
	}
	
	public List<Negocio> searchNegocio(Negocio negocio){
		try {
			if(negocio != null){
				return BaseNegocioPeer.doSelect(negocio);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o negocio: \n" + negocio.toString(), e);
		}
		return null;
	}
	
	public boolean removeNegocio(Negocio negocio){
		try{
			if(negocio != null){
				BaseNegocioPeer.doDelete(negocio);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o negocio de id[" + negocio.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateNegocio(Negocio negocio){
		try{
			if(negocio != null){
				BaseNegocioPeer.doUpdate(negocio);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o negocio de id[" + negocio.getId() + "]", e);
		}
		
		return false;
	}
}
