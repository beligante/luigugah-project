package com.saei.actions.usuario;

import java.util.ArrayList;
import java.util.List;

import com.saei.actions.BaseAction;
import com.saei.domain.enums.TipoPessoa;
import com.saei.domain.enums.TipoUsuario;
import com.saei.services.CidadeService;
import com.saei.services.EstadosService;

public class CadastroUsuarioAction extends BaseAction{

	
	// all struts logic here
	public String execute() {

		return SUCCESS;

	}
	
	public List<String> getEstados(){
		return EstadosService.getAllEstadosName();
	}
	
	public List<String> getCidades(){
		return CidadeService.getAllCidadesName();
	}
	
	public TipoPessoa[] getTiposPessoa(){
		return TipoPessoa.values();
	}
	
	public List<TipoUsuario> getTiposUsuario(){
		
		TipoUsuario[] tipos = TipoUsuario.values();
		List<TipoUsuario> tiposUsuario = new ArrayList<TipoUsuario>();
		for(int index = 0; index < tipos.length; index++){
			tiposUsuario.add(tipos[index]);
		}
		return tiposUsuario;
	}
}
