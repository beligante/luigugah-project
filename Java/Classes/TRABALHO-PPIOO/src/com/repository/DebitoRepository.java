package com.repository;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Debito;
import com.entity.Usuario;

public class DebitoRepository extends Repository<Debito>{
	
	public Collection<Debito> getDebitosEmAbertoByUsuario(Usuario usuario){
		Collection<Debito> debitos =  getAll();
		if(debitos != null && debitos.size() > 0){
			Collection<Debito> query = new ArrayList<Debito>();
			for(Debito debito : debitos){
				if(!debito.isPago() && debito.getUsuario().compareTo(usuario) == 0){
					query.add(debito);
				}
			}
			return query;
		}
		return null;
	}

}
