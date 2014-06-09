/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlets;

import com.controller.PacienteController;
import com.domain.Constants;
import com.domain.Paciente;
import com.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaPacienteServlet extends GenericServlet {

    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String query = request.getParameter("query");

        PacienteController controller
                = (PacienteController) request.getSession().getAttribute(Constants.PACIENTE_CONTROLLER_SECAO);
        List<Paciente> pacientes = null;

        if (StringUtils.isNotBlank(query)) {
            pacientes = (List<Paciente>) controller.searchByName(query);
        } else {
            pacientes = new ArrayList<Paciente>(controller.getAll());
        }
        request.setAttribute("pacientes", pacientes);

        request.setCharacterEncoding(Constants.ENCODING);
        request.getRequestDispatcher(Constants.BUSCA_PACIENTE_JSP).include(request, response);
    }

    @Override
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGetImpl(request, response);
    }

}
