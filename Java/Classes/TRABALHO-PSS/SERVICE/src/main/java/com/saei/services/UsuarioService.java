package com.saei.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.saei.domain.commons.BaseUsuarioPeer;
import com.saei.domain.commons.Usuario;
import com.saei.domain.commons.Usuario;
 
public class UsuarioService {
	
	private static final Logger LOG = Logger.getLogger(UsuarioService.class);
	
	public int salvarUsuario(Usuario usuario){
		
		try{
			if(usuario != null){
				BaseUsuarioPeer.doInsert(usuario);
				return usuario.getId();
			}
		}catch(Exception e){
			LOG.error("Ocorreu um erro ao salvar um novo usuario", e);
		}
		
		return -1;
	}
	
	public List<Usuario> searchUsuario(Usuario usuario){
		try {
			if(usuario != null){
				return BaseUsuarioPeer.doSelect(usuario);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o usuario: \n" + usuario.toString(), e);
		}
		return null;
	}
	
	public boolean removeUsuario(Usuario usuario){
		try{
			if(usuario != null){
				BaseUsuarioPeer.doDelete(usuario);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o usuario de id[" + usuario.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean updateUsuario(Usuario usuario){
		try{
			if(usuario != null){
				BaseUsuarioPeer.doUpdate(usuario);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o usuario de id[" + usuario	.getId() + "]", e);
		}
		
		return false;
	}
}
