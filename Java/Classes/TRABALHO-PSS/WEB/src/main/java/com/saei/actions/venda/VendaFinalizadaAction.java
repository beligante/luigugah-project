package com.saei.actions.venda;

import com.saei.actions.BaseAction;
import com.saei.constants.SessionConstants;
import com.saei.domain.Simulacao;
import com.saei.domain.commons.Negocio;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoNegociacao;
import com.saei.domain.enums.TipoPagamento;

public class VendaFinalizadaAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		
		Simulacao simulacao = (Simulacao) getServletRequest().getSession().getAttribute(SessionConstants.SIMULACAO_KEY);
		TipoPagamento tipoPagamento = (TipoPagamento) getServletRequest().getSession().getAttribute(SessionConstants.CHECKOUT_TIPO_PAGAMENTO);
		Produto product  = (Produto) getServletRequest().getSession().getAttribute(SessionConstants.CHECKOUT_PRODUCT_KEY);
		Usuario client = (Usuario) getServletRequest().getSession().getAttribute(SessionConstants.CHECKOUT_CLIENT_KEY);
		Usuario vendedor = (Usuario) getServletRequest().getSession().getAttribute(SessionConstants.CHECKOUT_CLIENT_KEY);
		
		Negocio negocio = new Negocio();
		negocio.setIdCliente(client.getId());
		negocio.setIdProduto(product.getId());
		negocio.setIdVendedor(vendedor.getId());
		negocio.setMeioPagamento(tipoPagamento.name());
		negocio.setValorFinalTotal(simulacao.getValorFinal());
		negocio.setTipoNegocio(TipoNegociacao.VENDA.name());
		
		getAplicationEng().getNegocioEng().registerNegocio(negocio, simulacao);
		
		return SUCCESS;
	}
}
