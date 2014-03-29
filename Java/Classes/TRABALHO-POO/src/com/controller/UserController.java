package com.controller;

import com.domain.Credencial;
import com.domain.Medico;
import com.domain.Usuario;
import com.repository.UserRepository;
import com.security.UserManager;
import com.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserController extends AbstractController<Usuario, UserRepository>{

	private Credencial credencial;
	
	public UserController(UserManager userManager){
		setRepository(userManager.getRepository());
		credencial = userManager.getCredencial();
	}
	
	public Usuario getLoginByCredencial(){
		Credencial databaseUser = getRepository().getCredencialByUser(credencial.getUser());
                
                if (databaseUser != null && databaseUser.equals(credencial)){
			return getRepository().getUsuarioByUser(credencial.getUser());
		}
		return null;
	}
	
        public Collection<Medico> getAllMedicos(){
            Collection<Medico> retorno = new ArrayList<Medico>();
            
            Collection<Usuario> usuarios = getRepository().getAll();
            
            if(CollectionUtils.isNotEmpty(usuarios)){
            
                for(Usuario usuario : usuarios){
                    if(usuario.getClass().isInstance(Medico.class)){
                        retorno.add((Medico)usuario);
                    }
                }
                return retorno;
            }
            
            return null;
        }
        
	@Override
	protected void removeImpl(Usuario entidade) {
		getRepository().remove(entidade);	
	}

	@Override
	protected void saveImpl(Usuario entidade) {
		getRepository().merge(entidade);		
	}

}
