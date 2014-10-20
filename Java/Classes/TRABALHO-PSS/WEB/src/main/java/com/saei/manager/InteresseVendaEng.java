package com.saei.manager;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;

import com.saei.domain.commons.InteresseVenda;
import com.saei.domain.commons.InteresseVendaHistorico;
import com.saei.domain.enums.TipoSituacao;
import com.saei.services.InteresseVendaHistoricoService;
import com.saei.services.InteresseVendaService;

public class InteresseVendaEng {

	private static InteresseVendaService INTERESSE_SERVICE;
	private static InteresseVendaHistoricoService INTERESSE_HISTORICO_SERVICE;
	
	static {
		INTERESSE_SERVICE = new InteresseVendaService();
		INTERESSE_HISTORICO_SERVICE = new InteresseVendaHistoricoService();
	}
	
	public InteresseVenda registerInteresseVenda (InteresseVenda interesseVend){
		InteresseVendaHistorico interesseVendHist = new InteresseVendaHistorico();
		interesseVend.setDataCadastro(new Date());
		interesseVendHist.setInteresseVendaId(INTERESSE_SERVICE.salvarInteresseVenda(interesseVend));
		interesseVendHist.setDataOcorrencia(interesseVend.getDataCadastro());
		interesseVendHist.setSituacao(TipoSituacao.PENDENTE.name());
		INTERESSE_HISTORICO_SERVICE.salvarInteresseVendaHistorico(interesseVendHist);
		
		return interesseVend;
	}
	
	
	public InteresseVendaHistorico registerInteresseVendaHistorico(InteresseVendaHistorico interesseVendHist){
		INTERESSE_HISTORICO_SERVICE.salvarInteresseVendaHistorico(interesseVendHist);
		
		return interesseVendHist;
	}
	
	public List<InteresseVenda> getAllInteresseVendas(){
		return INTERESSE_SERVICE.searchInteresseVenda(null);
	}
	
	public void deleteInteresseVendaByInteresseVenda(InteresseVenda interesseVend){
		if(interesseVend != null){
			deleteInteresseVendaById(interesseVend.getId());
		}
	}
	
	public void deleteInteresseVendaById(int id){
		InteresseVenda interesseVend = new InteresseVenda();
		interesseVend.setId(id);
		INTERESSE_SERVICE.removeInteresseVenda(interesseVend);
		for (InteresseVendaHistorico ivh : INTERESSE_HISTORICO_SERVICE.searchInteresseVendaHistoricoByInteresseVendaId(id)){
			INTERESSE_HISTORICO_SERVICE.removeInteresseVendaHistoricoById(ivh.getId());
		}
	}
	
	public InteresseVenda getInteresseVendaById(int id){
		return INTERESSE_SERVICE.searchInteresseVendaById(id);
	}
	
	public List<InteresseVendaHistorico> getInteresseVendaHistoricoByInteresseVendaId(int id){
		return INTERESSE_HISTORICO_SERVICE.searchInteresseVendaHistoricoByInteresseVendaId(id);
	}
	
	public void updateInteresseVendaByInteresseVenda(InteresseVenda interesseVend){
		INTERESSE_SERVICE.updateInteresseVenda(interesseVend);
	}


	public InteresseVendaHistorico getEstaduAtualInterresseById(int id) {
		return INTERESSE_HISTORICO_SERVICE.searchLastInteresseVendaHistoricoByInteresseVendaId(id);
	}
	
	
	public boolean existeInteresseByUserAndProduct(int userId, int productId){
		return (INTERESSE_SERVICE.searchInteresseVendaByProductAndUserId(userId,productId) != null);
	}
}
