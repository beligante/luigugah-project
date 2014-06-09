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
import com.utils.StringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class BuscarConsultaServlet extends GenericServlet{

    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String query = request.getParameter("query");
        
        ConsultaController controllerConsulta = (ConsultaController) request.getSession().getAttribute(Constants.CONSULTA_CONTROLLER_SECAO);
        Collection<Consulta> consultas = null;
        if(StringUtils.isNotBlank(query)){
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            consultas = controllerConsulta.searchByData(SDF.parse(query));
        }else{
            consultas = new ArrayList<Consulta>(controllerConsulta.getAll()); 
        }
        request.setAttribute("consultas", consultas);
        request.setCharacterEncoding(Constants.ENCODING);
        request.getRequestDispatcher(Constants.BUSCA_CONSULTA_JSP).include(request, response);    
        
    }

    @Override
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGetImpl(request, response);
    }
    
}
