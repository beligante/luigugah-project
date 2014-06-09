/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlets;

import com.controller.ConsultaController;
import com.controller.PacienteController;
import com.controller.UserController;
import com.domain.Constants;
import com.domain.Consulta;
import com.domain.Medico;
import com.domain.Paciente;
import com.domain.Usuario;
import com.enums.TipoConsulta;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class CadastroConsultaServlet extends GenericServlet {

    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
        ConsultaController controllerConsulta = (ConsultaController) request.getSession().getAttribute(Constants.CONSULTA_CONTROLLER_SECAO);
        UserController controllerUser = (UserController) request.getSession().getAttribute(Constants.USUARIO_CONTROLLER_SECAO);
        PacienteController controllerPaciente = (PacienteController) request.getSession().getAttribute(Constants.PACIENTE_CONTROLLER_SECAO);

        request.setAttribute("medicos", controllerUser.getAllMedicos());
        request.setAttribute("pacientes", controllerPaciente.getAll());
        
        String editId = request.getParameter("editId");
        String deleteId = request.getParameter("deleteId");

        if (StringUtils.isNotBlank(editId)) {
            List<Consulta> consultas = (List<Consulta>) controllerConsulta.searchById(Long.parseLong(editId));

            if (CollectionUtils.isNotEmpty(consultas)) {
                Consulta consulta = consultas.get(0);
                request.setAttribute("consulta", consulta);
            }
        }

        if (StringUtils.isNotBlank(deleteId)) {
            List<Consulta> consultas = (List<Consulta>) controllerConsulta.searchById(Long.parseLong(editId));

            if (CollectionUtils.isNotEmpty(consultas)) {
                Consulta consulta = consultas.get(0);
                controllerConsulta.remove(consulta);
            }
        
            response.sendRedirect(Constants.BUSCA_CONSULTA_ACTION);
        }
        
        request.setCharacterEncoding(Constants.ENCODING);
        request.getRequestDispatcher(Constants.CADASTRO_CONSULTA_JSP).include(request, response);
    }

    @Override 
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ConsultaController controllerConsulta = (ConsultaController) request.getSession().getAttribute(Constants.CONSULTA_CONTROLLER_SECAO);
        UserController controllerUser = (UserController) request.getSession().getAttribute(Constants.USUARIO_CONTROLLER_SECAO);
        PacienteController controllerPaciente = (PacienteController) request.getSession().getAttribute(Constants.PACIENTE_CONTROLLER_SECAO);

        String data_str = request.getParameter("dataConsulta"),
                hora_str = request.getParameter("horaConsulta"),
                medicoId = request.getParameter("medicoId"),
                pacienteId = request.getParameter("pacienteId"),
                tipoConsulta_str = request.getParameter("tipoConsulta"),
                consultaId = request.getParameter("consultaId");

        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date dataConsulta = SDF.parse(data_str + " " + hora_str);

        Medico medico = (Medico) ((List<Usuario>) controllerUser.searchById(Long.parseLong(medicoId))).get(0);
        Paciente paciente = ((List<Paciente>) controllerPaciente.searchById(Long.parseLong(pacienteId))).get(0);

        Consulta consulta = new Consulta();
        consulta.setDataConsulta(dataConsulta);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setTipoConsulta(TipoConsulta.valueOf(tipoConsulta_str));

        if (StringUtils.isNotBlank(consultaId)) {
            consulta.setId(Long.parseLong(consultaId));
        }

        if (!controllerConsulta.isExisteConsultaMarcadaParaHorario(dataConsulta, TipoConsulta.valueOf(tipoConsulta_str))) {
            controllerConsulta.save(consulta);
        }

        response.sendRedirect(Constants.BUSCA_CONSULTA_ACTION);
    }

}
