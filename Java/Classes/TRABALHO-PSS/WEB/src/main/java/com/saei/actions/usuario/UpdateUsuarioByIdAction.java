package com.saei.actions.usuario;

import java.util.ArrayList;
import java.util.List;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoPessoa;
import com.saei.domain.enums.TipoUsuario;
import com.saei.services.CidadeService;
import com.saei.services.EstadosService;

public class UpdateUsuarioByIdAction extends BaseAction{

	private String id;
	private Usuario usuario;
	
	@Override
	public String execute() throws Exception {
		
		Integer id = null;

		try{
			id = Integer.parseInt(this.id);
		}catch(Exception e){}
		
		if(id != null){
			usuario = getAplicationEng().getUsuarioEng().getUsuarioById(id);
		}
		
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
