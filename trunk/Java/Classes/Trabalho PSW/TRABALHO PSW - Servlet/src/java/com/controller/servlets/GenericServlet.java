package com.controller.servlets;

import com.controller.UserController;
import com.domain.Constants;
import com.domain.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class GenericServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
            try{
                
                Usuario usuario = (Usuario) req.getSession().getAttribute(Constants.USUARIO_SECAO);
                if(usuario == null){
                    resp.sendRedirect(Constants.LOGIN_ACTION);
                }
                
                doGetImpl(req, resp);
            }catch(Exception e){
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
            try{
                
                Usuario usuario = (Usuario) req.getSession().getAttribute(Constants.USUARIO_SECAO);
                if(usuario == null){
                    resp.sendRedirect(Constants.LOGIN_ACTION);
                }
                doPostImpl(req, resp);
            }catch(Exception e){
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
	}
	
	protected abstract void doGetImpl(HttpServletRequest request,HttpServletResponse response) throws Exception;	
	protected abstract void doPostImpl(HttpServletRequest request,HttpServletResponse response) throws Exception;
}