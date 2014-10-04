package com.saei.services;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.torque.util.Criteria;

import com.saei.domain.commons.BaseProdutoPeer;
import com.saei.domain.commons.BaseUsuarioPeer;
import com.saei.domain.commons.Usuario;
import com.saei.domain.enums.TipoUsuario;
 
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
			}else{
				return BaseUsuarioPeer.doSelect(new Criteria());
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o usuario: \n" + usuario.toString(), e);
		}
		return null;
	}
	
	public boolean removeUsuario(Usuario usuario){
		try{
			if(usuario != null){
				removeUsuarioById(usuario.getId());
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o usuario de id[" + usuario.getId() + "]", e);
		}
		
		return false;
	}
	
	public boolean removeUsuarioById(int id){
		try{
			Criteria c = new Criteria();
			c.add(BaseUsuarioPeer.ID, id);
				BaseUsuarioPeer.doDelete(c);
				return true;
			
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o usuario de id[" + id + "]", e);
		}
		
		return false;
	}
	
	public boolean updateUsuario(Usuario usuario){
		try{
			if(usuario != null){
				usuario.setModified(true);
				usuario.setNew(false);
				BaseUsuarioPeer.doUpdate(usuario);
				return true;
			}
		}catch (Exception e) {
			LOG.error("Ocorreu um erro ao remover o usuario de id[" + usuario	.getId() + "]", e);
		}
		
		return false;
	}

	public Usuario searchUsuarioById(int id) {
		try {
			Criteria c = new Criteria();
			c.add(BaseUsuarioPeer.ID, id);
			List<Usuario> usuarios = BaseUsuarioPeer.doSelect(c);
			if(CollectionUtils.isNotEmpty(usuarios)){
				return usuarios.get(0);
			}
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar o usuario de id[" + id + "]" , e);
		}
		return null;
	}
	
	public List<Usuario> getAllVendedores(){
		try {
			return BaseUsuarioPeer.doSelect(new Criteria()
						.add(BaseUsuarioPeer.TIPO_USUARIO, TipoUsuario.VENDEDOR.toString()));
		} catch (Exception e) {
			LOG.error("Ocorreu um erro ao buscar os usuarios vendedores", e);
		}
		return null;
	}
}
