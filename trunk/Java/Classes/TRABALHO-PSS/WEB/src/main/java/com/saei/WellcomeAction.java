package com.saei;

import java.util.Date;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;

import com.saei.domain.commons.Usuario;
import com.saei.services.UsuarioService;

public class WellcomeAction{

	// all struts logic here
	public String execute() throws TorqueException {

		Torque.init("torque.properties");
		Usuario usuario = new Usuario();
		
		usuario.setBairro("Oi");
		usuario.setCep("888888");
		usuario.setCidade("Maringa");
		usuario.setComplemento("a");
		usuario.setDataCadastro(new Date());
		usuario.setEmail("a@a.com");
		usuario.setEndereco("AAAAAA");
		usuario.setEstado("ooooo");
		
		UsuarioService us = new UsuarioService();
		
		int id = us.salvarUsuario(usuario);
		
		return "SUCCESS";

	}
}