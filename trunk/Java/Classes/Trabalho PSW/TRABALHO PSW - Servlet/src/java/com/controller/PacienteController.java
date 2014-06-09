package com.controller;

import com.domain.Paciente;
import com.domain.Prontuario;
import com.repository.Repository;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PacienteController extends AbstractController<Paciente, Repository<Paciente>>{

        ProntuarioController prontuarioController;
        
        public PacienteController(ProntuarioController prontuarioController) {
            super();
            this.prontuarioController = prontuarioController;
        }
	
        
    
	@Override
	protected void removeImpl(Paciente entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Paciente entidade) {
		
                if(!getRepository().exists(entidade)){
                    Prontuario prontuario = new Prontuario();
                    prontuario.setPaciente(entidade);
                    prontuario.setDataModificacao(new Date());
                    prontuarioController.save(prontuario);
                }
                
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
