package com.saei.manager;

import java.util.List;

import com.saei.domain.commons.FaturaPagamento;
import com.saei.services.FaturaPagamentoService;
import com.saei.services.NegocioService;
import com.saei.services.PagamentoService;

public class PagamentoEng {
	private static PagamentoService PAGAMENTO_SERVICE;
	private static FaturaPagamentoService FATURA_PAGAMENTO_SERVICE;
	private static NegocioService NEGOCIO_SERVICE;
	
	static{
		PAGAMENTO_SERVICE = new PagamentoService();
		FATURA_PAGAMENTO_SERVICE = new FaturaPagamentoService();
		NEGOCIO_SERVICE = new NegocioService();
	}
	
	public List<FaturaPagamento> getAllPagamentosByUsuario(Integer id){
		List<Integer> ids =  NEGOCIO_SERVICE.getAllIdsNegocioByUsuarioId(id);
		List<Integer> pagamentosIds = PAGAMENTO_SERVICE.getAllPagamentosIdByNegociosId(ids);
		return FATURA_PAGAMENTO_SERVICE.getAllByPagamentosId(pagamentosIds);
		
	}
}
