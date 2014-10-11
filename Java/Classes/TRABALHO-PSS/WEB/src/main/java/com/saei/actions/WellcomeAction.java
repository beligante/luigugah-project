package com.saei.actions;

import org.apache.log4j.Logger;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;

import com.saei.domain.commons.Compra;
import com.saei.domain.commons.FaturaPagamento;
import com.saei.domain.commons.HistoricoCompra;
import com.saei.domain.commons.ModalidadeNegociacao;
import com.saei.domain.commons.Negocio;
import com.saei.domain.commons.Pagamento;
import com.saei.domain.commons.Produto;
import com.saei.domain.commons.Usuario;
import com.saei.services.CompraService;
import com.saei.services.FaturaPagamentoService;
import com.saei.services.HistoricoCompraService;
import com.saei.services.ModalidadeNegociacaoService;
import com.saei.services.NegocioService;
import com.saei.services.PagamentoService;
import com.saei.services.ProdutoService;
import com.saei.services.UsuarioService;

public class WellcomeAction{

	private static final Logger LOG = Logger.getLogger(WellcomeAction.class);
	
	// all struts logic here
	public String execute() throws TorqueException {

		Torque.init("torque.properties");

		UsuarioService us = new UsuarioService();
		int id = us.salvarUsuario(new Usuario());
		int usuarioId = id;
		LOG.info(id);
		
		ProdutoService ps = new ProdutoService();
		id = ps.salvarProduto(new Produto());
		int produtoId = id;
		LOG.info(id);
		
		Negocio negocio = new Negocio();
		negocio.setIdCliente(usuarioId);
		negocio.setIdVendedor(usuarioId);
		negocio.setIdProduto(produtoId);
		NegocioService ns = new NegocioService();
		id = ns.salvarNegocio(negocio);
		int negocioId = id;
		LOG.info(id);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setIdNegocio(negocioId);
		PagamentoService pgs = new PagamentoService();
		id = pgs.salvarPagamento(pagamento);
		int pagamentoId = id;
		LOG.info(id);
		
		
		ModalidadeNegociacao mn = new ModalidadeNegociacao();
		mn.setProdutoId(produtoId);
		ModalidadeNegociacaoService mns = new ModalidadeNegociacaoService();
		id = mns.salvarModalidadeNegociacao(mn);
		LOG.info(id);
		
		Compra c = new Compra();
		c.setIdCliente(usuarioId);
		CompraService cs = new CompraService();
		id = cs.salvarCompra(c);
		int compraId = id;
		LOG.info(id);
		
		HistoricoCompra historicoCompra = new HistoricoCompra();
		historicoCompra.setCompraId(compraId);
		historicoCompra.setVendedorId(usuarioId);
		HistoricoCompraService hcs = new HistoricoCompraService();
		id = hcs.salvarHistoricoCompra(historicoCompra);
		LOG.info(id);
		
		FaturaPagamento faturaPagamento = new FaturaPagamento();
		faturaPagamento.setIdPagamento(pagamentoId);
		FaturaPagamentoService fps = new FaturaPagamentoService();
		id = fps.salvarFaturaPagamento(faturaPagamento);
		LOG.info(id);
		
		
		return "SUCCESS";

	}
}