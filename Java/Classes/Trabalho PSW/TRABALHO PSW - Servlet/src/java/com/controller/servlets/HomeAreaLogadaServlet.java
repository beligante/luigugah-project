/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.controller.servlets;

import com.domain.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo
 */
public class HomeAreaLogadaServlet extends GenericServlet{

    @Override
    protected void doGetImpl(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding(Constants.ENCODING);
            request.getRequestDispatcher(Constants.HOME_JSP).include(request, response);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HomeAreaLogadaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(HomeAreaLogadaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeAreaLogadaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPostImpl(HttpServletRequest request, HttpServletResponse response) {
        doGetImpl(request, response);
    }
    
}
