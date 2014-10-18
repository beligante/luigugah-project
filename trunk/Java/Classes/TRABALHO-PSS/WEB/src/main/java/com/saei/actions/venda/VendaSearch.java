package com.saei.actions.venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Negocio;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoPagamento;

public class VendaSearch extends BaseAction{
	
	@Override
	public String execute() throws Exception {
		
		List<Negocio> vendas = getAplicationEng().getNegocioEng().getAllVendas();
		
		Map<Integer, Usuario> usuariosMap = new HashMap<Integer, Usuario>();
		List<VendaVO> vendasVO = new ArrayList<VendaSearch.VendaVO>();
		
		VendaVO vo = null;
		Usuario cliente = null;
		Usuario vendedor = null;
		for(Negocio venda : vendas){
			vo = new VendaVO();
			vo.setNegocio(venda);
			if(usuariosMap.get(venda.getIdCliente()) == null){
				cliente = getAplicationEng().getUsuarioEng().getUsuarioById(venda.getIdCliente());
				if(cliente != null){
					usuariosMap.put(cliente.getId(), cliente);
				}
			}
			
			vo.setComprador(usuariosMap.get(venda.getIdCliente()));
			
			if(usuariosMap.get(venda.getIdVendedor()) == null){
				vendedor = getAplicationEng().getUsuarioEng().getUsuarioById(venda.getIdVendedor());
				if(vendedor != null){
					usuariosMap.put(vendedor.getId(), vendedor);
				}
			}
			
			vo.setVendedor(usuariosMap.get(venda.getIdVendedor()));
			
			vo.setMeioPagamento(TipoPagamento.findByName(venda.getMeioPagamento()));
			
			vendasVO.add(vo);
		}
		
		if(CollectionUtils.isEmpty(vendasVO)){
			addActionMessage("Não existem vendas feitas!");
		}
		
		request.setAttribute("vendas", vendasVO);
		return SUCCESS;
	}
	
	public class VendaVO{
		private Negocio negocio;
		private Usuario comprador;
		private Usuario vendedor;
		private TipoPagamento meioPagamento;
		
		public Negocio getNegocio() {
			return negocio;
		}
		public void setNegocio(Negocio negocio) {
			this.negocio = negocio;
		}
		public Usuario getComprador() {
			return comprador;
		}
		public void setComprador(Usuario comprador) {
			this.comprador = comprador;
		}
		public Usuario getVendedor() {
			return vendedor;
		}
		public void setVendedor(Usuario vendedor) {
			this.vendedor = vendedor;
		}
		public TipoPagamento getMeioPagamento() {
			return meioPagamento;
		}
		public void setMeioPagamento(TipoPagamento meioPagamento) {
			this.meioPagamento = meioPagamento;
		}
	}
}
