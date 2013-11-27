package com.ui;

import java.util.List;

import com.controller.UsuarioController;
import com.entity.Usuario;
import com.enums.Regras;

public class LoginUI {

	private UsuarioController usuarioController;
	private Usuario usuario;
	public void doScreen(){
		
	}

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Regras> getScreens(){
		return usuario.getPerfil().getRegras();
	}
}
