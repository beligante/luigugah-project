package com.controller;

import com.domain.Consulta;
import com.enums.TipoConsulta;
import com.repository.Repository;
import com.utils.CollectionUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class ConsultaController extends AbstractController<Consulta, Repository<Consulta>>{

	@Override
	protected void removeImpl(Consulta entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Consulta entidade) {
		getRepository().merge(entidade);
		
	}
        
        public boolean isExisteConsultaMarcadaParaHorario(Date data, TipoConsulta tipoConsulta){
            Collection<Consulta> consultasNoDia = getAllConsultasDadoDia(data);
            if(CollectionUtils.isEmpty(consultasNoDia)){return false;}
            
            for (Consulta consulta : consultasNoDia) {
                Date fimConsulta = getHoraFimConsulta(consulta.getDataConsulta(), 
                                                      consulta.getTipoConsulta());
                
                if(isDataContidaNoIntervaloDeTempo(fimConsulta, data)){
                    return true;
                }                    
            }
            return false;
        }
        
        private Collection<Consulta> getAllConsultasDadoDia(Date data){
            Collection<Consulta> consultas = getRepository().getAll();
            
            if(CollectionUtils.isNotEmpty(consultas)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date dataToCompare = sdf.parse(sdf.format(data));
                    Date dateToBeCompared = null;

                    Collection<Consulta> retorno = new ArrayList<Consulta>();
                    for (Consulta consulta : consultas) {
                        dateToBeCompared =  sdf.parse(sdf.format(consulta.getDataConsulta()));                    
                        if(dataToCompare.equals(dateToBeCompared)){
                            retorno.add(consulta);
                        }
                    }

                    return retorno;

                }catch(Exception e){}
            
            }
            return null;
        }
        
        private Date getHoraFimConsulta(Date data, TipoConsulta tipoConsulta){
            Calendar dataFimConsulta = Calendar.getInstance();
            dataFimConsulta.setTime(data);
            
            float tempoConsultaEmHoras = tipoConsulta.getDuracaoConsulta()/60;
            
            if(tempoConsultaEmHoras >= 1){
                dataFimConsulta.add(Calendar.HOUR_OF_DAY, 1);
            }else{
                dataFimConsulta.add(Calendar.MINUTE, 30);
            }
            return dataFimConsulta.getTime();
        }
        
        private boolean isDataContidaNoIntervaloDeTempo(Date terminoConsultaAtual,
                                                        Date inicioConsultaASerMarcada){
            
            if(terminoConsultaAtual.equals(inicioConsultaASerMarcada)){return false;}
            
            return terminoConsultaAtual.after(inicioConsultaASerMarcada);
        }

    public Collection<Consulta> searchByData(Date query) {
        return getAllConsultasDadoDia(query);
    }
    
    public Collection<Consulta> getAllConsultasDiaSeguinte(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        
        return getAllConsultasDadoDia(calendar.getTime());
    }
    
    public Collection<Consulta> getAll(){
        return getRepository().getAll();
    }

}
