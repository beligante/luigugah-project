<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comum/Taglibs.jsp" %>

<s:form action="update-produto-submit" cssStyle="color:black">

	<s:hidden name="produto.id"></s:hidden>
	
	<s:textfield 
		label="CEP"
		name="produto.cep" 
		cssClass="form-control"/>	
	<s:textfield 
		label="Endereço"
		name="produto.endereco" 
		cssClass="form-control"/>
	<s:textfield 
		label="Bairro"
		name="produto.bairro" 
		cssClass="form-control"/>
	
	<s:textfield 
		label="Complemento"
		name="produto.complemento" 
		cssClass="form-control"/>
	<s:select label="Estado" name="produto.estado" list="estados"></s:select>
	<s:select label="Cidade" name="produto.cidade" list="cidades"></s:select>
	<s:textfield 
		label="Dimensao"
		name="produto.dimensoes" 
		cssClass="form-control"/>
		
	<s:select label="Tipo" name="produto.tipoProduto" list="tiposProduto"></s:select>
	<s:textarea label="Descrição" cssClass="form-control" name="produto.descricao"></s:textarea>

	<s:textfield 
		label="Preço"
		name="produto.preco" 
		cssClass="form-control"/>
	<s:textfield 
		label="Link imagem"
		name="produto.linkFoto" 
		cssClass="form-control"/>
	<s:submit label="Cadastrar"></s:submit>

</s:form>