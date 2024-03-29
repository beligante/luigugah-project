<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="../comum/Taglibs.jsp" %>

<s:form action="update-usuario-submit" >

	<s:hidden name="usuario.id"></s:hidden>
	<s:textfield 
		label="Nome"
		name="usuario.nome" 
		cssClass="form-control">
	</s:textfield>
		
	<s:textfield 
		label="Email"
		name="usuario.email" 
		cssClass="form-control">
	</s:textfield>	
	
	<s:textfield 
		label="Telefone"
		name="usuario.telefone" 
		cssClass="form-control">
	</s:textfield>	
	
	<s:radio 
		label="Tipo Pessoa"
		list="tiposPessoa" 
		listKey="label" 
		listValue="sigla" 
		name="usuario.tipoPessoa"></s:radio>
	
	<s:textfield 
		label="Endereco"
		name="usuario.endereco" 
		cssClass="form-control">
	</s:textfield>	
	<s:textfield 
		label="Bairro"
		name="usuario.bairro" 
		cssClass="form-control">
	</s:textfield>	
	<s:textfield 
		label="Complemento"
		name="usuario.complemento" 
		cssClass="form-control">
	</s:textfield>	
	<s:textfield 
		label="Cep"
		name="usuario.cep" 
		cssClass="form-control">
	</s:textfield>	
	<s:select 
		label="Cidade"
		list="cidades"
		name="usuario.cidade" 
		cssClass="form-control">
	</s:select>	
	<s:select 
		label="Estado"
		list="estados"
		name="usuario.estado" 
		cssClass="form-control">
	</s:select>	
	<s:textfield 
		label="Usuario"
		name="usuario.usuario" 
		cssClass="form-control">
	</s:textfield>	
	<s:password 
		label="Senha"
		name="usuario.senha" 
		cssClass="form-control">
	</s:password>	
	<s:select 
		name="usuario.tipoUsuario"
		list="tiposUsuario" 
		label="Tipo Usuario">
	</s:select>
		
	<s:submit label="Cadastrar"></s:submit>
</s:form>