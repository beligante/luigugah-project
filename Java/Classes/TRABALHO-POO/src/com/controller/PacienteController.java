package com.controller;

import com.domain.Alergia;
import com.domain.Cirurgia;
import com.domain.Paciente;
import com.domain.Prontuario;
import com.repository.Repository;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacienteController extends AbstractController<Paciente, Repository<Paciente>> {

    ProntuarioController prontuarioController;
    Repository<Cirurgia> cirurgiaRepository = new Repository<Cirurgia>(Cirurgia.class);
    Repository<Alergia> alergiaRepository = new Repository<Alergia>(Alergia.class);
    

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

       try{
        //Se não possui ID é porque é novo
        boolean isNew = (entidade.getId() == null);
        
        List<Cirurgia> cirurgias = entidade.getCirurgias();
        List<Alergia> alergia = entidade.getAlergias();
        
        List<Cirurgia> cirurgiasNull = null;
        List<Alergia> alergiaNull = null;
        
        entidade.setCirurgias(cirurgiasNull);
        entidade.setAlergias(alergiaNull);
        
        getRepository().merge(entidade);

        if (isNew) {
            Prontuario prontuario = new Prontuario();
            prontuario.setPaciente(entidade);
            prontuario.setDataModificacao(new Date());
            prontuarioController.save(prontuario);
        }
        
        for(Cirurgia c : cirurgias){
            c.setPaciente(entidade);
            cirurgiaRepository.merge(c);
        }
        
        for(Alergia a : alergia){
            a.setPaciente(entidade);
            alergiaRepository.merge(a);
        }
        }catch(Exception e){
            Logger.getLogger(this.getClass().getCanonicalName()).log(Level.SEVERE, "Ocorreu um erro ao salvar o paciente", e);
        }
    }

    public Collection<Paciente> getAll() {
        return getRepository().getAll();
    }

    public Collection<Paciente> searchByName(String query) {
        Collection<Paciente> pacientes = getRepository().getAll();
        
        List<Paciente> result = new ArrayList<Paciente>();
        if (CollectionUtils.isNotEmpty(pacientes)) {

            if (StringUtils.isBlank(query)) {
                return pacientes;
            }

            for (Paciente paciente : pacientes) {
                if (paciente.getNome().contains(query)) {
                    result.add(paciente);
                }
            }
            return result;
        }
        return null;
    }

}
