package com.controller;

import com.domain.Paciente;
import com.repository.Repository;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PacienteController extends AbstractController<Paciente, Repository<Paciente>>{
	
	@Override
	protected void removeImpl(Paciente entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Paciente entidade) {
		getRepository().merge(entidade);
		
	}
        
        public Collection<Paciente> getAll(){
            return getRepository().getAll();
        }
        
        public Collection<Paciente> searchByName(String query){
            Collection<Paciente> pacientes = getRepository().getAll();
            
            List<Paciente> result = new ArrayList<Paciente>();
            if(CollectionUtils.isNotEmpty(pacientes)){
                
                if(StringUtils.isBlank(query)){
                    return pacientes;
                }
                
                for (Paciente paciente : pacientes) {
                    if(paciente.getNome().contains(query)){
                        result.add(paciente);
                    }
                }
                return result;
            }
            return null;
        }

}
