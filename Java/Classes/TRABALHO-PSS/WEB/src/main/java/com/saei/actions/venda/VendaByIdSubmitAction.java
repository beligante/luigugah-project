package com.saei.actions.venda;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.constants.SessionConstants;
import com.saei.domain.Simulacao;
import com.saei.domain.commons.JurosParcelamento;
import com.saei.domain.commons.Negocio;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoPagamento;
import com.saei.services.DataPagamentoService;
import com.saei.services.JurosParcelamentoService;
import com.saei.services.JurosService;
import com.saei.services.SimulacaoService;
import com.saei.services.exceptions.JurosServiceException;

public class VendaByIdSubmitAction extends BaseAction{

	private String cliente;
	private String vendedor;
	private String produto;
	private String entrada;
	private String parcelas;
	private String tipoPagamento;
	private String vencimentoBoleto;
	
	private static final String CATALOGO_ACTION = "catalogo";
	
	@Override
	public String execute() throws Exception {
		
		int clientId = -1;
		Usuario cliente = null;
		try{
			clientId = Integer.parseInt(this.cliente);
			cliente = getAplicationEng().getUsuarioEng().getUsuarioById(clientId);
		}catch(Exception e){}
		if(clientId < 0 || cliente == null){
			addActionError("Cliente invalido!");
			return CATALOGO_ACTION;
		}
		
		int vendedorId = -1;
		Usuario vendedor = null;
		try{
			vendedorId = Integer.parseInt(this.vendedor);
			vendedor = getAplicationEng().getUsuarioEng().getUsuarioById(vendedorId);
		}catch(Exception e){}
		if(vendedorId < 0 || vendedor == null){
			addActionError("Vendedor invalido!");
			return CATALOGO_ACTION;
		}
		
		int produtoId = -1;
		Produto produto = null;
		try{
			produtoId = Integer.parseInt(this.produto);
			produto = getAplicationEng().getProdutoEng().getProdutoById(produtoId);
		}catch(Exception e){}
		
		if(produtoId < 0 || produto == null){
			addActionError("Produto invalido!");
			return CATALOGO_ACTION;
		}

		BigDecimal entradaBig = null;
		try{entradaBig = new BigDecimal(entrada);}catch(Exception e){}
		if(entradaBig == null && entradaBig.floatValue() < 0){
			addActionError("Valor de entrada n�o pode ser menor que zero ou invalido!");
			return CATALOGO_ACTION;
		}

		int intParcelas = -1;
		try{intParcelas = Integer.parseInt(parcelas);}catch(Exception e){}
		if(intParcelas < 0){
			addActionError("Numero de parcelas n�o pode ser menor que zero");			
			return CATALOGO_ACTION;
		}
		
		TipoPagamento pagamento = TipoPagamento.findByName(tipoPagamento);
		if(pagamento == null){
			addActionError("Tipo de pagamento selecionado � inv�lido!");
			return CATALOGO_ACTION;
		}
		
		int intVencimentoBoleto = -1;
		try{intVencimentoBoleto = Integer.parseInt(vencimentoBoleto);}catch(Exception e){}
		if(intVencimentoBoleto < 1 && TipoPagamento.BOLETO_MENSAL.equals(pagamento)){
			
			addActionError("Dia do vencimento do boleto inv�lido!");
			return CATALOGO_ACTION;
		}
		if(entradaBig.compareTo(produto.getPreco()) > 0){
			addActionError("Valor de entrada n�o pode ser superior ao valor do produto");
			return CATALOGO_ACTION;
		}
		
		if(!DataPagamentoService.isDiaPagamentoValido(intVencimentoBoleto, intParcelas, new Date())){
			addActionError("Dia do vencimento do boleto inv�lido!");
			return CATALOGO_ACTION;
		}
		Simulacao simulacao;
		try{
			List<JurosParcelamento> jurosConfigs = JurosParcelamentoService.getAllJurosParcelamento();
			JurosService js = new JurosService(jurosConfigs);
		
			BigDecimal precoComEntradaDescontada = produto.getPreco().subtract(entradaBig);
		
			simulacao = SimulacaoService.generateSimulation(
								produto.getPreco(), 
								js.getPorcentagemJurosByValorAndQuantidadeParcelas(precoComEntradaDescontada,intParcelas),
								entradaBig, 
								intParcelas);
			simulacao.setDiaVencimentoBoleto(intVencimentoBoleto);
		}catch(Exception e){
			addActionError("Ocorreu um erro ao gera a simulacao, tente novamente!");
			LOG.error("Ocorreu um erro ao gera a simulacao", e);
			return CATALOGO_ACTION;
		}

		request.getSession().setAttribute(SessionConstants.SIMULACAO_KEY , simulacao);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_PRODUCT_KEY, produto);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_CLIENT_KEY, cliente);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_VENDEDOR_KEY, vendedor);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_TIPO_PAGAMENTO, pagamento);
		request.setAttribute("dataPrimeiraParcela", DataPagamentoService.getDataPagamentoProximoMesByDataAtual(new Date(), intVencimentoBoleto));
		
		return SUCCESS; 
	}

	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}


	public String getVencimentoBoleto() {
		return vencimentoBoleto;
	}


	public void setVencimentoBoleto(String vencimentoBoleto) {
		this.vencimentoBoleto = vencimentoBoleto;
	}

}
