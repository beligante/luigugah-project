package com.repository;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Exemplar;
import com.entity.Obra;

public class ExemplarRepository extends Repository<Exemplar> {
	
	public Collection<Exemplar> getExemplaresNaoEmprestados(Obra obra){
		Collection<Exemplar> exemplares = getAll();
		
		if(exemplares != null && exemplares.size() > 0){
			Collection<Exemplar> query = new ArrayList<Exemplar>();
			
			for(Exemplar exemplar :  exemplares){
				if((exemplar.getObra().compareTo(obra) == 0) && !exemplar.isEmprestado()){
					query.add(exemplar);
				}
			}
			return query;
		}
		
		return null;
	}

	public Collection<Exemplar> getExemplares(Obra obra){
		Collection<Exemplar> exemplares = getAll();
		
		if(exemplares != null && exemplares.size() > 0){
			Collection<Exemplar> query = new ArrayList<Exemplar>();
			
			for(Exemplar exemplar :  exemplares){
				if((exemplar.getObra().compareTo(obra) == 0)){
					query.add(exemplar);
				}
			}
			return query;
		}
		
		return null;
	}
}
