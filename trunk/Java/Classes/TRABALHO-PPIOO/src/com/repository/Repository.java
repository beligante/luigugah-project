package com.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.entity.Entity;

public class Repository<Entidade extends Entity> {
	
	protected Map<Long, Entidade> repositorio;
	
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
		List<Long> combinacoesId = getCombinacoesPossiveisDadoId(id);
		List<Entidade> resultado = new ArrayList<Entidade>();
		for(Long combinacao : combinacoesId){
			Entidade e = repositorio.get(combinacao);
			if(e != null)
				resultado.add(e);
		}
		
		return resultado;
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
}
