package com.saei.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BasePagamentoPeer;
import com.saei.domain.commons.Pagamento;
import com.workingdogs.village.Record;

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
			LOG.error("Ocorreu um erro ao buscar o pagamento", e);
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
	
	public List<Integer> getAllPagamentosIdByNegociosId(List<Integer> ids){
		try{
			Criteria c = new Criteria();
			c.addIn(BasePagamentoPeer.ID_NEGOCIO, ids);
			c.addSelectColumn(BasePagamentoPeer.ID);
			List<Record> records = BasePeer.doSelect(c);
			List<Integer> pagamentosIds = new ArrayList<Integer>();
			if(CollectionUtils.isNotEmpty(records)){
				for(Record record : records){
					pagamentosIds.add(record.getValue(BasePagamentoPeer.ID).asInt());
				}
			}
			return pagamentosIds;
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar os pagamentos para os negocios de id[" + ids + "]", e);
		}
		
		return null;
	}

}
