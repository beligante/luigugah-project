package com.saei.actions.venda;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.InteresseVenda;
import com.saei.domain.commons.InteresseVendaHistorico;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoSituacao;

public class VendaIntrestManagerAction extends BaseAction{
	
	public String execute() {
		
		List<VendaInteresseVO> interesse = parseToInteresseVendaVOList();
		
		if(CollectionUtils.isEmpty(interesse)){
			addActionMessage("Não existem interesses de venda cadastrados");
		}
		
		request.setAttribute("interessesVendaVO",interesse);
		
		return SUCCESS;
	}
	
	private List<VendaInteresseVO> parseToInteresseVendaVOList(){
		List<InteresseVenda> interesses = getAplicationEng().getInteresseVendaEng().getAllInteresseVendas();
		if(CollectionUtils.isEmpty(interesses)){return null;}
		
		List<VendaInteresseVO> vos = new ArrayList<VendaIntrestManagerAction.VendaInteresseVO>();
		VendaInteresseVO vendaInteresse = null;
		for(InteresseVenda interesse: interesses){
			vendaInteresse = new VendaInteresseVO();
			vendaInteresse.setInteresseVenda(interesse);
			vendaInteresse.setInteresseVendaHistorico(getAplicationEng().getInteresseVendaEng().getEstaduAtualInterresseById(interesse.getId()));
			vos.add(vendaInteresse);
		}
		
		return vos;
	}
	
	public class VendaInteresseVO{
		InteresseVenda interesseVenda;
		InteresseVendaHistorico interesseVendaHistorico;
		String tipoSituacao;

		public String getTipoSituacao() {
			return tipoSituacao;
		}

		public void setTipoSituacao(String tipoSituacao) {
			this.tipoSituacao = tipoSituacao;
		}

		public void setInteresseVenda(InteresseVenda interesseVenda) {
			this.interesseVenda = interesseVenda;
		}

		public void setInteresseVendaHistorico(InteresseVendaHistorico interesseVendaHistorico) {
			this.setTipoSituacao(TipoSituacao.findTipoSituacaoByName(interesseVendaHistorico.getSituacao()).getLabel());
			this.interesseVendaHistorico = interesseVendaHistorico;
		}

		public InteresseVenda getInteresseVenda() {
			return interesseVenda;
		}

		public InteresseVendaHistorico getInteresseVendaHistorico() {
			return interesseVendaHistorico;
		}
		
	}
}
