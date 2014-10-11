package com.saei.services;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BaseInteresseVendaHistoricoPeer;
import com.saei.domain.commons.BaseInteresseVendaHistorico;
import com.saei.domain.commons.InteresseVendaHistorico;

public class InteresseVendaHistoricoService {
	
	private static final Logger LOG = Logger.getLogger(InteresseVendaHistoricoService.class);
	
	public int salvarInteresseVendaHistorico(InteresseVendaHistorico interesseVend){
		try{
			if (interesseVend != null){
				BaseInteresseVendaHistoricoPeer.doInsert(interesseVend);
				return interesseVend.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar o Interesse de Venda historico", e);
		}
		return -1;
	}

	public List<InteresseVendaHistorico> searchInteresseVendaHistorico(InteresseVendaHistorico interesseVend){
		try {
			if(interesseVend != null){
				return BaseInteresseVendaHistoricoPeer.doSelect(interesseVend);
			}else{
				return BaseInteresseVendaHistoricoPeer.doSelect(new Criteria());
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o Interesse de Venda historico: \n" + interesseVend.toString(), e);
		}
		return null;
	}
	
	public List<InteresseVendaHistorico> searchInteresseVendaHistoricoByInteresseVendaId(int id){
		try{
			Criteria c = new Criteria();
			c.add(BaseInteresseVendaHistoricoPeer.INTERESSE_VENDA_ID, id);
			c.addDescendingOrderByColumn(BaseInteresseVendaHistoricoPeer.DATA_OCORRENCIA);
			List<InteresseVendaHistorico> interesses = BaseInteresseVendaHistoricoPeer.doSelect(c);
			if(CollectionUtils.isNotEmpty(interesses)){
				return interesses;
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar interesse de venda historico com INTERESSE_VENDA_ID[" + id + "]" , e);
		}
		return null;
	}
	
	public InteresseVendaHistorico searchInteresseVendaHistoricoById(int id){
		try {
			Criteria c = new Criteria();
			c.add(BaseInteresseVendaHistoricoPeer.ID, id);
			List<InteresseVendaHistorico> interesses = BaseInteresseVendaHistoricoPeer.doSelect(c);
			if(CollectionUtils.isNotEmpty(interesses)){
				return interesses.get(0);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o interesse de venda historico de id[" + id + "]" , e);
		}
		return null;
	}

	public boolean removeInteresseVendaHistorico(InteresseVendaHistorico interesseVend){
		try{
			if(interesseVend != null){
				return removeInteresseVendaHistoricoById(interesseVend.getId());
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o interesse de venda historico de id[" + interesseVend.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean removeInteresseVendaHistoricoById(int id){
		try{
			Criteria c = new Criteria();
			c.add(BaseInteresseVendaHistoricoPeer.ID, id);
				BaseInteresseVendaHistoricoPeer.doDelete(c);
				return true;
			
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o interesse de venda historico de id[" + id + "]", e);
		}
		
		return false;
	}
	
	public boolean updateInteresseVendaHistorico(InteresseVendaHistorico interesseVend){
		try{
			if(interesseVend != null){
				interesseVend.setNew(false);
				interesseVend.setModified(true);
				BaseInteresseVendaHistoricoPeer.doUpdate(interesseVend);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o interesse de venda historico de id[" + interesseVend.getId() + "]", e);
		}
		
		return false;
	}

	public InteresseVendaHistorico searchLastInteresseVendaHistoricoByInteresseVendaId(int id) {
		try{
			Criteria c = new Criteria();
			c.add(BaseInteresseVendaHistoricoPeer.INTERESSE_VENDA_ID, id);
			c.addDescendingOrderByColumn(BaseInteresseVendaHistoricoPeer.DATA_OCORRENCIA);
			c.setLimit(1);
			List<InteresseVendaHistorico> interesses = BaseInteresseVendaHistoricoPeer.doSelect(c);
			if(CollectionUtils.isNotEmpty(interesses)){
				return interesses.get(0);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o last interesse de venda historico com INTERESSE_VENDA_ID[" + id + "]" , e);
		}
		return null;
	}
	
}
