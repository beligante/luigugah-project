package com.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.domain.Entity;
import com.domain.Paciente;

public class Repository<Entidade extends Entity> {
	
	protected Map<Long, Entidade> repositorio;
	
	public Repository(){
		repositorio = new HashMap<Long, Entidade>();
	}

    public Repository(Class<Paciente> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public Repository<Entidade> merge(Entidade entidade){
		
		repositorio.put(entidade.getId(), entidade);
		
		return this;
	}
	
	public Repository<Entidade> remove(Entidade entidade){
		
		repositorio.remove(entidade.getId());
		
		return this;
	}
	
	public Repository<Entidade> remove(Long id){
		
		repositorio.remove(id);
		
		return this;
	}
	
	public List<Entidade> search(Long id){
                ArrayList<Entidade> a = new ArrayList<Entidade>();
		a.add(repositorio.get(id));
                return a;
	}

	private List<Long> getCombinacoesPossiveisDadoId(Long id) {
		
		
		String idAsString = id.toString();
		
		List<Long> combinacoes = new ArrayList<Long>();
		
		for(int i = 0; i < idAsString.length(); i++){
			for(int j = 0; j < idAsString.length(); j++){
				if(j <= i)
					combinacoes.add(Long.parseLong(idAsString.substring(j, i)));
			}
		}
	
		return combinacoes;
	}
	
	public Collection<Entidade> getAll(){
		return repositorio.values();
	}
        
        public boolean exists(Entidade entidade){
            
            if(entidade == null){return false;}
            return repositorio.containsValue(entidade.getId());
        }
}