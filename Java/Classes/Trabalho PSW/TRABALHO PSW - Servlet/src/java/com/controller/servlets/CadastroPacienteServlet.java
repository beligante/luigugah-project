package com.controller.servlets;

import com.controller.PacienteController;
import com.domain.Constants;
import com.domain.Paciente;
import com.enums.TipoAtendimento;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroPacienteServlet extends GenericServlet{

    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String editId = request.getParameter("editId");
            String deleteId = request.getParameter("deleteId");
            
            if(StringUtils.isNotBlank(editId)){
                PacienteController controller =
                (PacienteController) request.getSession().getAttribute(Constants.PACIENTE_CONTROLLER_SECAO);
                List<Paciente> pacientes = (List<Paciente>) controller.searchById(Long.parseLong(editId));
                
                if(CollectionUtils.isNotEmpty(pacientes)){
                    Paciente paciente = pacientes.get(0);
                    request.setAttribute("paciente", paciente);
                }
            }
            
            if(StringUtils.isNotBlank(deleteId)){
                PacienteController controller =
                (PacienteController) request.getSession().getAttribute(Constants.PACIENTE_CONTROLLER_SECAO);
                List<Paciente> pacientes = (List<Paciente>) controller.searchById(Long.parseLong(deleteId));

                if(CollectionUtils.isNotEmpty(pacientes)){
                    Paciente paciente = pacientes.get(0);
                    controller.remove(paciente);
                    response.sendRedirect(Constants.BUSCA_PACIENTE_ACTION);
                    return;
                }
            }
            
            request.setCharacterEncoding(Constants.ENCODING);
            request.getRequestDispatcher(Constants.CADASTRO_PACIENTE_JSP).include(request, response);    
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HomeAreaLogadaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(HomeAreaLogadaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeAreaLogadaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String nome, rg, cpf, dataNascimento_str, endereco, 
                telefoneFixo, telefoneCelular,tipoPlano_str,
                isCardiaco_str, isAlcolatra_str, isDiabetico_str, isFumante_str;
        
        nome = request.getParameter("nome");
        rg = request.getParameter("rg");
        cpf = request.getParameter("cpf");
        dataNascimento_str = request.getParameter("dataNascimento");
        endereco = request.getParameter("endereco");
        telefoneFixo = request.getParameter("telefoneFixo");
        telefoneCelular = request.getParameter("telefoneCelular");
        tipoPlano_str = request.getParameter("tipoPlano");
        isCardiaco_str = request.getParameter("isCardiaco");
        isAlcolatra_str = request.getParameter("isAlcolatra"); 
        isDiabetico_str = request.getParameter("isDiabetico");
        isFumante_str = request.getParameter("isFumante");
        
        String idPaciente = request.getParameter("idPaciente");
        
        List<String> parametros = new ArrayList<String>();
        parametros.add(nome);
        parametros.add(rg);
        parametros.add(cpf);
        parametros.add(dataNascimento_str);
        parametros.add(endereco);
        parametros.add(telefoneFixo);
        parametros.add(telefoneCelular);
        parametros.add(tipoPlano_str);
        
        if(StringUtils.isAnyParamEmpty(parametros)){
            response.sendRedirect(Constants.CADASTRO_PACIENTE_ACTION);
            return;
        }

        
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd"); 
        Date dataNascimento = SDF.parse(dataNascimento_str);
        
        TipoAtendimento tipoAtendimento = TipoAtendimento.valueOf(tipoPlano_str);
        
        Paciente p = new Paciente();
        
        if(StringUtils.isNotBlank(idPaciente)){
            p.setId(Long.parseLong(idPaciente));
        }
        
        p.setNome(nome);
        p.setRg(rg);
        p.setCpf(cpf);
        p.setDataNascimento(dataNascimento);
        p.setTipoAtendimento(tipoAtendimento);
        p.setEndereco(endereco);
        p.setTelefone(telefoneFixo);
        p.setIsCardiaco(getBooleanValueForCheckBox(isCardiaco_str));
        p.setIsAlcolatra(getBooleanValueForCheckBox(isAlcolatra_str));
        p.setIsDiabetico(getBooleanValueForCheckBox(isDiabetico_str));
        p.setIsFumante(getBooleanValueForCheckBox(isFumante_str));
        
        PacienteController controller =
                (PacienteController) request.getSession().getAttribute(Constants.PACIENTE_CONTROLLER_SECAO);
    
        controller.save(p);
        
        response.sendRedirect(Constants.HOME_AREA_LOGADA_ACTION);
    }
    
    private boolean getBooleanValueForCheckBox(String parameter){
        return "ON".equalsIgnoreCase(parameter);
    }
}
