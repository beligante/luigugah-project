/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlets;

import com.controller.ProntuarioController;
import com.domain.Constants;
import com.domain.Consulta;
import com.domain.Prontuario;
import com.utils.CollectionUtils;
import com.utils.StringUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class CadastroProntuarioServlet extends GenericServlet {

    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProntuarioController controller = 
                (ProntuarioController) request.getSession().getAttribute(Constants.PRONTUARIO_CONTROLLER_SECAO);

        String editId = request.getParameter("editId");
        String deleteId = request.getParameter("deleteId");

        if (StringUtils.isNotBlank(editId)) {
            List<Prontuario> prontuarios = (List<Prontuario>) controller.searchById(Long.parseLong(editId));
            /*
            if (CollectionUtils.isNotEmpty(prontuarios)) {
                Prontuario prontuario = prontuarios.get(0);
                request.setAttribute("prontuario", prontuario);
            }
            */
        }

        if (StringUtils.isNotBlank(deleteId)) {
            List<Prontuario> prontuarios = (List<Prontuario>) controller.searchById(Long.parseLong(deleteId));

            if (CollectionUtils.isNotEmpty(prontuarios)) {
                Prontuario prontuario = prontuarios.get(0);
                controller.remove(prontuario);
            }

            response.sendRedirect(Constants.BUSCA_PRONTUARIO_ACTION);
        }

        response.sendRedirect(Constants.BUSCA_PRONTUARIO_ACTION); //APAGAR
        //request.setCharacterEncoding(Constants.ENCODING);
        //request.getRequestDispatcher(Constants.CADASTRO_PRONTUARIO_JSP).include(request, response);
    }

    @Override
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(Constants.BUSCA_PRONTUARIO_ACTION);
    }

}
