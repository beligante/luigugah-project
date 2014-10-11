package com.saei.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.saei.domain.Simulacao;
import com.saei.domain.commons.FaturaPagamento;
import com.saei.domain.commons.Negocio;
import com.saei.domain.commons.Pagamento;
import com.saei.services.DataPagamentoService;
import com.saei.services.FaturaPagamentoService;
import com.saei.services.NegocioService;
import com.saei.services.PagamentoService;

public class NegocioEng {

		private static NegocioService NEGOCIO_SERVICE;
		
		static {
			NEGOCIO_SERVICE = new NegocioService();
		}
		
		public Negocio registerNegocio(Negocio negocio, Simulacao simulacao){
			
			negocio.setId(NEGOCIO_SERVICE.salvarNegocio(negocio));
			
			List<FaturaPagamento> faturas = new ArrayList<FaturaPagamento>();
			
			FaturaPagamento fatura = new FaturaPagamento();
			Date dataVencimento = new Date();
			for(int contador = 0; contador < simulacao.getQuantidadeParcelas(); contador++){
				dataVencimento = DataPagamentoService.getDataPagamentoProximoMesByDataAtual(dataVencimento, simulacao.getDiaVencimentoBoleto());
				fatura.setVencimento(dataVencimento);
				fatura.setValor(simulacao.getValorParcelas());
				fatura.setLinkBoleto("/archives/boleto.pdf");
				faturas.add(fatura);
			}
			
			Pagamento pagamento = new Pagamento();
			pagamento.setInicioPagamento(faturas.get(0).getVencimento());
			pagamento.setFimPagamento(faturas.get(faturas.size() - 1).getVencimento());
			pagamento.setIdNegocio(negocio.getId());
			
			PagamentoService pgs = new PagamentoService();
			pagamento.setId(pgs.salvarPagamento(pagamento));
			
			FaturaPagamentoService fps = new FaturaPagamentoService();
			for(FaturaPagamento fat : faturas){
				fat.setIdPagamento(pagamento.getId());
				fps.salvarFaturaPagamento(fat);
			}
			
			return negocio;
		}
		
		public List<Negocio> getAllNegocios(){
			return NEGOCIO_SERVICE.searchNegocio(null);
		}
		
		public void deleteNegocioByNegocio(Negocio negocio){
			if(negocio != null){
				deleteNegocioById(negocio.getId());
			}
		}
		
		public void deleteNegocioById(int id){
			Negocio negocio = new Negocio();
			negocio.setId(id);
			NEGOCIO_SERVICE.removeNegocio(negocio);
		}
		
		public Negocio getNegocioById(int id){
			return NEGOCIO_SERVICE.searchNegocioById(id);
		}
		
		public List<Negocio> searchNegocioByNegocio(Negocio negocio){
			return NEGOCIO_SERVICE.searchNegocio(negocio);
		}
		
		public void updateNegocioByNegocio(Negocio negocio){
			NEGOCIO_SERVICE.updateNegocio(negocio);
		}		
}
