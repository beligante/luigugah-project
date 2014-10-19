package com.saei.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.torque.TorqueException;

import com.saei.domain.commons.JurosParcelamento;
import com.saei.services.exceptions.AmbiguousConfigurationException;
import com.saei.services.exceptions.InvalidConfigurationException;
import com.saei.services.exceptions.NoConfigurationException;

public class JurosService {
	
	private List<JurosParcelamento> configuracoes;
	
	public JurosService(List<JurosParcelamento> configuracoes) throws NoConfigurationException, InvalidConfigurationException, AmbiguousConfigurationException{
		if(CollectionUtils.isEmpty(configuracoes)){
			
			throw new NoConfigurationException("Erro ao instanciar a classe. É necessário pelo menos uma configuração");
		}
		
		checkConfigurations(configuracoes);
		
		this.configuracoes = configuracoes;
		
	}  

	private void checkConfigurations(List<JurosParcelamento> configuracoes) 
				throws 	NoConfigurationException, 
						InvalidConfigurationException, 
						AmbiguousConfigurationException {
		if(CollectionUtils.isEmpty(configuracoes)){
			
			throw new NoConfigurationException("Erro ao instanciar a classe. É necessário pelo menos uma configuração");
		}
		
		for(JurosParcelamento configuracao : configuracoes){
			if(configuracao.getValorTotal() == null || configuracao.getValorTotal().floatValue() < 0){
				throw new InvalidConfigurationException("O Valor total da configuração não pode ser nulo ou menor que zero");
			}
			
			if(configuracao.getQuantidadeParcelas()  < 1){
				throw new InvalidConfigurationException("A quantidade de parcelas não pode ser menor que 1");
			}
			
			if(configuracao.getPorcentagemJuros() == null || configuracao.getPorcentagemJuros().floatValue() < 0){
				throw new InvalidConfigurationException("O valor de porcentagem da configuração não pode ser nulo ou menor que zero");
			}
			
		}

		boolean isValorIgual = false;
		boolean isQuantidadeParcelasIgual = false;
		List<JurosParcelamento> cloneList = null;
		int indexAtual = 0;
		
		for(JurosParcelamento configuracao : configuracoes){
			cloneList = cloneListAndRemoveIndex(configuracoes, indexAtual);
			if(CollectionUtils.isEmpty(cloneList)){break;}
			for(JurosParcelamento comparador : cloneList){
				isValorIgual = configuracao.getValorTotal().compareTo(comparador.getValorTotal()) == 0;
				isQuantidadeParcelasIgual = configuracao.getQuantidadeParcelas() == comparador.getQuantidadeParcelas();
						if((isValorIgual && isQuantidadeParcelasIgual)){
							throw new AmbiguousConfigurationException("Não podem existir configurações ambiguas na lista de configurações");
						}
			}
			
			indexAtual++;
		}
	}
	
	private List<JurosParcelamento> cloneListAndRemoveIndex(List<JurosParcelamento> configuracoes, int indexAtual) {
		List<JurosParcelamento> cloneList = cloneList(configuracoes);
		if(CollectionUtils.isEmpty(cloneList)){return null;}
		cloneList.remove(indexAtual);
		return cloneList;
	}

	private List<JurosParcelamento> cloneList(List<JurosParcelamento> configuracoes){
		
		if(CollectionUtils.isEmpty(configuracoes)){return null;}
		
		List<JurosParcelamento> configuracoesClone = new ArrayList<JurosParcelamento>();
		for(JurosParcelamento configuracao : configuracoes){
			try {
				configuracoesClone.add(configuracao.copy());
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return configuracoesClone;
	}
	
	public BigDecimal getPorcentagemJurosByValorAndQuantidadeParcelas(BigDecimal valorTotal, int quantidadeParcelas) throws NoConfigurationException{
		if(CollectionUtils.isEmpty(configuracoes)){
			throw new NoConfigurationException("Erro ao instanciar a classe. É necessário pelo menos uma configuração");
		}
		
		if(valorTotal == null || quantidadeParcelas < 0){
			return BigDecimal.ZERO;
		}

		BigDecimal melhorConfiguracao = BigDecimal.ZERO;
		BigDecimal configuracaoAtual = null;
		
		for(JurosParcelamento configuracao : configuracoes){
			configuracaoAtual = null;
			if(configuracao.getValorTotal().compareTo(valorTotal) <= 0 
					&& configuracao.getQuantidadeParcelas() <= quantidadeParcelas){
				configuracaoAtual = configuracao.getPorcentagemJuros();
			}
			
			if(configuracaoAtual != null){ melhorConfiguracao = configuracaoAtual;}
		}
		
		
		return melhorConfiguracao;
	}
	
	/**
	 * Copia a lista de configurações para um outro objeto
	 * para evitar alterações externas
	 * 
	 * @return Lista Clonada de configurações
	 */
	public List<JurosParcelamento> getSafeConfiguracoes(){
		
		return cloneList(this.configuracoes);
	}
	
}
