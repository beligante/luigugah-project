package com.saei.actions.venda;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.constants.SessionConstants;
import com.saei.domain.Simulacao;
import com.saei.domain.commons.Negocio;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoPagamento;
import com.saei.services.DataPagamentoService;
import com.saei.services.SimulacaoService;

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
		if(clientId < 0 || cliente == null){return CATALOGO_ACTION;}
		
		int vendedorId = -1;
		try{vendedorId = Integer.parseInt(vendedor);}catch(Exception e){}
		if(vendedorId < 0){return CATALOGO_ACTION;}
		
		int produtoId = -1;
		Produto produto = null;
		try{
			produtoId = Integer.parseInt(this.produto);
			produto = getAplicationEng().getProdutoEng().getProdutoById(produtoId);
		}catch(Exception e){}
		
		if(produtoId < 0 || produto == null){return CATALOGO_ACTION;}

		BigDecimal entradaBig = null;
		try{entradaBig = new BigDecimal(entrada);}catch(Exception e){}
		if(entradaBig == null){return CATALOGO_ACTION;}

		int intParcelas = -1;
		try{intParcelas = Integer.parseInt(parcelas);}catch(Exception e){}
		if(intParcelas < 0){return CATALOGO_ACTION;}
		
		TipoPagamento pagamento = TipoPagamento.findByName(tipoPagamento);
		if(pagamento == null){return CATALOGO_ACTION;}
		
		int intVencimentoBoleto = -1;
		try{intVencimentoBoleto = Integer.parseInt(vencimentoBoleto);}catch(Exception e){}
		if(intVencimentoBoleto < 0 && TipoPagamento.BOLETO_MENSAL.equals(pagamento)){return CATALOGO_ACTION;}
		
		try{intParcelas = Integer.parseInt(parcelas);}catch(Exception e){}
		if(intParcelas < 0){return CATALOGO_ACTION;}
		
		if(entradaBig.compareTo(produto.getPreco()) > 0){return CATALOGO_ACTION;}
		
		if(!DataPagamentoService.isDiaPagamentoValido(intVencimentoBoleto, intParcelas, new Date())){
			return CATALOGO_ACTION;
		}
		
		
		Simulacao simulacao = SimulacaoService.generateSimulation(
								produto.getPreco(), 
								new BigDecimal(1.3), 
								entradaBig, 
								intParcelas);
		simulacao.setDiaVencimentoBoleto(intVencimentoBoleto);

		request.getSession().setAttribute(SessionConstants.SIMULACAO_KEY , simulacao);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_PRODUCT_KEY, produto);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_CLIENT_KEY, cliente);
		request.getSession().setAttribute(SessionConstants.CHECKOUT_VENDEDOR_KEY, vendedorId);
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
