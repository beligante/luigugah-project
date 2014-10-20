package com.saei.actions.usuario;

import org.apache.commons.lang.StringUtils;

import com.saei.actions.BaseAction;
import com.saei.domain.commons.Usuario;

public class CadastroUsuarioSubmitAction  extends BaseAction {

	private Usuario usuario;
	
	@Override
	public String execute() throws Exception {

		if(StringUtils.isNotEmpty(usuario.getNome())){
			addActionError("O Nome não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getEmail())){
			addActionError("O Email não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getTelefone())){
			addActionError("O Telefone não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getTipoUsuario())){
			addActionError("Escolha um tipo de pessoa!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getEndereco())){
			addActionError("O Endereco não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getBairro())){
			addActionError("O Bairro não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getCep())){
			addActionError("O CEP não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getUsuario())){
			addActionError("O Usuario não pode ser nullo!");
			return SUCCESS;
		}
		
		if(StringUtils.isNotEmpty(usuario.getSenha())){
			addActionError("A Senha não pode ser nulla!");
			return SUCCESS;
		}
		
		getAplicationEng().getUsuarioEng().registerUsuario(usuario);
		addActionMessage("Usuario Cadastrado Com Sucesso!");
		return SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
