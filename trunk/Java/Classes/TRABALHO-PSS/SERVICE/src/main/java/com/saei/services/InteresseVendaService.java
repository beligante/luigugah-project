package com.saei.services;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BaseInteresseVendaPeer;
import com.saei.domain.commons.BaseInteresseVenda;
import com.saei.domain.commons.InteresseVenda;

public class InteresseVendaService {
	
	private static final Logger LOG = Logger.getLogger(ProdutoService.class);
	
	public int salvarInteresseVenda(InteresseVenda interesseVend){
		try{
			if (interesseVend != null){
				BaseInteresseVendaPeer.doInsert(interesseVend);
				return interesseVend.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar o Interesse de Venda", e);
		}
		return -1;
	}

	public List<InteresseVenda> searchInteresseVenda(InteresseVenda interesseVend){
		try {
			if(interesseVend != null){
				return BaseInteresseVendaPeer.doSelect(interesseVend);
			}else{
				return BaseInteresseVendaPeer.doSelect(new Criteria());
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o Interesse de Venda: \n" + interesseVend.toString(), e);
		}
		return null;
	}
	
	public InteresseVenda searchInteresseVendaById(int id){
		try {
			Criteria c = new Criteria();
			c.add(BaseInteresseVendaPeer.ID, id);
			List<InteresseVenda> interesses = BaseInteresseVendaPeer.doSelect(c);
			if(CollectionUtils.isNotEmpty(interesses)){
				return interesses.get(0);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o interesse de venda de id[" + id + "]" , e);
		}
		return null;
	}

	public boolean removeInteresseVenda(InteresseVenda interesseVend){
		try{
			if(interesseVend != null){
				return removeInteresseVendaById(interesseVend.getId());
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o interesse de venda de id[" + interesseVend.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean removeInteresseVendaById(int id){
		try{
			Criteria c = new Criteria();
			c.add(BaseInteresseVendaPeer.ID, id);
				BaseInteresseVendaPeer.doDelete(c);
				return true;
			
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o interesse de venda de id[" + id + "]", e);
		}
		
		return false;
	}
	
	public boolean updateInteresseVenda(InteresseVenda interesseVend){
		try{
			if(interesseVend != null){
				interesseVend.setNew(false);
				interesseVend.setModified(true);
				BaseInteresseVendaPeer.doUpdate(interesseVend);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o interesse de venda de id[" + interesseVend.getId() + "]", e);
		}
		
		return false;
	}
	
	
}
