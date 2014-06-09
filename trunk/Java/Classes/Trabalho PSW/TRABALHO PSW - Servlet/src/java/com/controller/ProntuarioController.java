package com.controller;

import com.domain.Prontuario;
import com.repository.Repository;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProntuarioController extends AbstractController<Prontuario, Repository<Prontuario>>{

	@Override
	protected void removeImpl(Prontuario entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Prontuario entidade) {
		getRepository().merge(entidade);
		
	}

        public Collection<Prontuario> searchByNomePaciente(String query){
            Collection<Prontuario> all = getRepository().getAll();
            
            if(CollectionUtils.isEmpty(all)){return null;}
            if(StringUtils.isBlank(query)){return all;}
            
            List<Prontuario> result = new ArrayList<Prontuario>();
            
            for (Prontuario prontuario : all){
                if(prontuario.getPaciente().getNome().contains(query)){
                    result.add(prontuario);
                }
            }
            return result;
        }
        
        public Collection<Prontuario> getAll(){
            return getRepository().getAll();
        }
}
