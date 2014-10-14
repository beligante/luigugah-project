package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BaseNegocioPeer;
import com.saei.domain.commons.Negocio;
import com.saei.domain.enums.TipoNegociacao;

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
			}else{
				return BaseNegocioPeer.doSelect(new Criteria());
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o negocio: \n" + negocio.toString(), e);
		}
		return null;
	}
	
	public List<Negocio> getAllVendas(){
		try {
			Criteria c = new Criteria();
			c.add(BaseNegocioPeer.TIPO_NEGOCIO, TipoNegociacao.VENDA.name());
			return BaseNegocioPeer.doSelect(c);
			
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar vendas na base", e);
		}
		return null;
	}
	
	public Negocio searchNegocioById(int id){
		try {
				Criteria c = new Criteria();
				c.add(BaseNegocioPeer.ID, id);
				//Se vier nullo, cai no catch e retorna nullo
				return (Negocio) BaseNegocioPeer.doSelect(c).get(0);
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o negocio de Id: " + id, e);
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
