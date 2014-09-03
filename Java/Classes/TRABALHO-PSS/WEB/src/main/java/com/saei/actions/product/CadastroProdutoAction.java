package com.saei.actions.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.saei.actions.BaseAction;
import com.saei.domain.enums.TipoProduto;
import com.saei.services.CidadeService;
import com.saei.services.EstadosService;

public class CadastroProdutoAction extends BaseAction {
	
	// all struts logic here
	public String execute() {

		List<String> cidades = new ArrayList<String>();
		cidades.add("Maringa");
		
		List<String> estados = new ArrayList<String>();
		estados.add("PR");

		getServletRequest().setAttribute("estados", estados);
		getServletRequest().setAttribute("cidades", cidades);
		
		List<String> tipoProduto = new ArrayList<String>();
		for(TipoProduto tipo : TipoProduto.values()){
			tipoProduto.add(tipo.getLabel());
		}
		
		getServletRequest().setAttribute("tiposProduto", tipoProduto);
		
		return SUCCESS;

	}
	
	public List<String> getEstados(){
		return EstadosService.getAllEstadosName();
	}
	
	public List<String> getCidades(){
		return CidadeService.getAllCidadesName();
	}
	
	public List<String> getTiposProduto(){
		List<String> tipoProduto = new ArrayList<String>();
		for(TipoProduto tipo : TipoProduto.values()){
			tipoProduto.add(tipo.getLabel());
		}
		return tipoProduto;
	}
	

}
