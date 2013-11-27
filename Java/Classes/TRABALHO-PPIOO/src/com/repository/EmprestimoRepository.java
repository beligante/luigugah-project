package com.repository;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Emprestimo;
import com.entity.Usuario;

public class EmprestimoRepository extends Repository<Emprestimo>{

		public Collection<Emprestimo> getEmprestimosByUsuario(Usuario usuario){
			
			Collection<Emprestimo> emprestimos = getAll();
			if(emprestimos != null && emprestimos.size() > 0){
				
				Collection<Emprestimo>  query = new ArrayList<Emprestimo>();
				for(Emprestimo emprestimo : emprestimos){
					
					if(emprestimo.getUsuario().compareTo(usuario) == 0){
						query.add(emprestimo);
					}
				}
				return query;
			}
			return null;
		}

}
