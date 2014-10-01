package com.saei.actions.venda;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Negocio;
import com.saei.domain.enums.TipoPagamento;

public class VendaByIdSubmitAction extends BaseAction{

	private String cliente;
	private String vendedor;
	private String produto;
	private String entrada;
	private String parcelas;
	private String tipoPagamento;
	
	private static final String CATALOGO_ACTION = "catalogo";
	
	@Override
	public String execute() throws Exception {
		
		String validationResult = validateActionParameters();
		
		if(StringUtils.isNotEmpty(validationResult)){
			return validationResult;
		}
		
		
		return SUCCESS;
	}

	private String validateActionParameters(){
		int clientId = -1;
		try{clientId = Integer.parseInt(cliente);}catch(Exception e){}
		if(clientId < 0){return CATALOGO_ACTION;}
		
		int vendedorId = -1;
		try{vendedorId = Integer.parseInt(vendedor);}catch(Exception e){}
		if(vendedorId < 0){return CATALOGO_ACTION;}
		
		int produtoId = -1;
		try{produtoId = Integer.parseInt(produto);}catch(Exception e){}
		if(produtoId < 0){return CATALOGO_ACTION;}

		BigDecimal entradaBig = null;
		try{entradaBig = new BigDecimal(entrada);}catch(Exception e){}
		if(entradaBig == null){return CATALOGO_ACTION;}

		int intParcelas = -1;
		try{intParcelas = Integer.parseInt(parcelas);}catch(Exception e){}
		if(intParcelas < 0){return CATALOGO_ACTION;}
		
		TipoPagamento pagamento = TipoPagamento.findByName(tipoPagamento);
		if(pagamento == null){return CATALOGO_ACTION;}
		
		try{intParcelas = Integer.parseInt(parcelas);}catch(Exception e){}
		if(intParcelas < 0){return CATALOGO_ACTION;}
		
		return null;
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

}
