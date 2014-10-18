package com.saei.actions.venda;

import java.util.Date;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.InteresseVendaHistorico;

public class VendaIntrestManagerUpdateSubmitAction extends BaseAction {
	

	private String interesseDescricao;
	private String interesseSituacao;
	private Integer interesseId;
	
	@Override
	public String execute() throws Exception {
		InteresseVendaHistorico interesseVendHist = new InteresseVendaHistorico();
		
		interesseVendHist.setDescricao(interesseDescricao);
		interesseVendHist.setSituacao(interesseSituacao);
		interesseVendHist.setDataOcorrencia(new Date());
		interesseVendHist.setInteresseVendaId(interesseId);
		
		getAplicationEng().getInteresseVendaEng().registerInteresseVendaHistorico(interesseVendHist);
		
		addActionSuccess("Interesse editado com sucesso !");
		
		return SUCCESS;
	}

	
	//---------GET AND SET----------//
	public String getInteresseSituacao() {
		return interesseSituacao;
	}
	public void setInteresseSituacao(String interesseSituacao) {
		this.interesseSituacao = interesseSituacao;
	}
	public String getInteresseDescricao() {
		return interesseDescricao;
	}
	public void setInteresseDescricao(String interesseDescricao) {
		this.interesseDescricao = interesseDescricao;
	}
	public Integer getInteresseId() {
		return interesseId;
	}
	public void setInteresseId(Integer interesseId) {
		this.interesseId = interesseId;
	}

}
