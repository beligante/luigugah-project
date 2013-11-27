package com.controller;

import java.util.Collection;

import com.entity.Perfil;
import com.entity.Usuario;
import com.repository.Repository;

public class CriacaoPerfilController
							extends AbstractController<Perfil, Repository<Perfil>>{


	private UsuarioController usuarioController;
	
	@Override
	protected void saveImpl(
			Perfil entidade) {
		
		getRepository().merge(entidade);
	}

	@Override
	protected void removeImpl(Perfil entidade) {
		getRepository().remove(entidade);
		
	}
	
	public void remove(Perfil remove, Perfil changeTo){
		Collection<Usuario> usuarios = usuarioController.getAllUsers();
		
		if(usuarios != null){
			for(Usuario usuario : usuarios){
				if(usuario.getPerfil().compareTo(remove) == 0){
					usuario.setPerfil(changeTo);
					usuarioController.save(usuario);
				}
			}
			
		}
		
		getRepository().remove(remove);
	}

}
