/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller.servlets;

import com.controller.ProntuarioController;
import com.domain.Constants;
import com.utils.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class BuscaProntuarioServlet extends GenericServlet {
    
    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProntuarioController controller
                = (ProntuarioController) request.getSession().getAttribute(Constants.PRONTUARIO_CONTROLLER_SECAO);
        
        String query = (String) request.getAttribute("query");
        
        if (StringUtils.isNotBlank(query)) {
            request.setAttribute("prontuarios", controller.searchByNomePaciente(query));
        } else {
            request.setAttribute("prontuarios", controller.getAll());
        }
        
        request.setCharacterEncoding(Constants.ENCODING);
        request.getRequestDispatcher(Constants.BUSCA_PRONTUARIO_JSP).include(request, response);        
        
    }
    
    @Override
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doGetImpl(request, response);
    }
    
}
