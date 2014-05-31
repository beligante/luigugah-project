package com.repository;

import com.domain.Credencial;
import com.domain.Usuario;
import com.utils.CollectionUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository extends Repository<Usuario> {

    private Map<String, String> loginMap;
    private Map<String, Long> userMap;

    public UserRepository() {
        super(Usuario.class);
        
        Collection<Usuario> usuarios = getAll();
        
        loginMap = new HashMap<String, String>();
        userMap = new HashMap<String, Long>();
        
        if(CollectionUtils.isNotEmpty(usuarios)){
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
                loginMap.put(usuario.getUser(), usuario.getPassword());
                userMap.put(usuario.getUser(), usuario.getId().longValue());
                repositorio.put(usuario.getId(), usuario);
            }
            
        }
    }

    public Repository<Usuario> merge(Usuario usuario) {
        super.merge(usuario);
        loginMap.put(usuario.getUser(), usuario.getPassword());
        userMap.put(usuario.getUser(), usuario.getId().longValue());
        return this;
    }

    public Repository<Usuario> remove(Usuario usuario) {
        loginMap.remove(usuario.getUser());
        userMap.remove(usuario.getUser());
        return super.remove(usuario);

    }

    public Credencial getCredencialByUser(String user) {
        String password = loginMap.get(user);
        if (password != null) {
            return new Credencial(user, password);
        }
        return null;
    }

    public Usuario getUsuarioByUser(String user) {
        Long id = userMap.get(user);
        if (id != null) {
            return repositorio.get(id);
        }
        return null;
    }
}
