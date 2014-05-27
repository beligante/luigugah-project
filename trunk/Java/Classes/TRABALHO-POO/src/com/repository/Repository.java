package com.repository;

import com.domain.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

public class Repository<Entidade extends Entity> {
	
        private Session session;
	protected Map<Long, Entidade> repositorio;
	
	public Repository(){
                session = HibernateUtil.getSessionFactory().openSession();
		repositorio = new HashMap<Long, Entidade>();
	}
	
	public Repository<Entidade> merge(Entidade entidade){
		
                session.beginTransaction();
                session.merge(entidade);
                session.getTransaction().commit();
                
		repositorio.put(entidade.getId(), entidade);
		
		return this;
	}
	
	public Repository<Entidade> remove(Entidade entidade){
		
            
                session.beginTransaction();
                session.delete(entidade);
                session.getTransaction().commit();
                
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
        
        public boolean exists(Entidade entidade){
            
            if(entidade == null){return false;}
            return repositorio.containsValue(entidade.getId());
        }
}