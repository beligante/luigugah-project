<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro Paciente</title>
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="stylesheet" type="text/css" href="css/cadastro-paciente.css">

    </head>
    <body>
        <header>
            <%@include file="../comum/header.jsp" %>
            <%@include file="../comum/menu.jsp" %>
        </header>

        <section id="container">		
            <form id="form" method="POST" action="cadastroPaciente">

                <c:if test="${not empty paciente}">
                    <input type="hidden" name="idPaciente" value="${paciente.id}">
                </c:if>
                <div class="div1">
                    <label class="title">Cadastro de Paciente</label> 
                </div>

                <div class="div1">
                    <label for="nome">Nome</label> 
                    <input required class="first" name="nome" value="${paciente.nome}" type="text">
                </div>

                <div class="div1">
                    <label for="cpf">CPF</label>
                    <input required value="${paciente.cpf}" name="cpf" type="text">
                </div>

                <div class="div1">	
                    <label for="rg">RG</label>
                    <input required name="rg" value="${paciente.rg}" type="text">
                </div>

                <div class="div1">		
                    <label for="dataNascimento">Data de nascimento</label>
                    <input required value="<fmt:formatDate pattern="yyyy-MM-dd" value="${paciente.dataNascimento}" />" name="dataNascimento" type="date">
                </div>

                <div class="div1">
                    <label for="endereco">Endereço</label>
                    <input required name="endereco" value="${paciente.endereco}" type="text">
                </div>

                <div class="div1">
                    <label for="telefoneFixo">Telefone Fixo</label>
                    <input required name="telefoneFixo" value="${paciente.telefone}" type="text">
                </div>

                <div class="div1">
                    <label for="telefoneCelular">Telefone Celular</label>
                    <input required class="last" name="telefoneCelular" value="${paciente.telefone}" type="text">
                </div>

                <div class="div1">
                    <label for="tipoPlano">Tipo do Plano</label>
                    <select name="tipoPlano" value="${paciente.tipoAtendimento}">
                        <option value="PARTICULAR" >Particular</option>
                        <option value="PLANO">Plano de saúde</option>
                    </select>
                </div>

                <div class="cropped-border"></div>

                <div class="div1">
                    <label for="colesterol">Nº Colesterol</label>
                    <input required class="rounded-border" value="0" name="colesterol" type="text">
                </div>

                <div class="div1">
                    <label for="isAlcolatra">Bebe?</label>
                    <input type="checkbox" value="${paciente.isAlcolatra}" name="isAlcolatra">
                </div>

                <div class="div1">
                    <label for="isFumante">Fuma?</label>
                    <input type="checkbox" value="${paciente.isFumante}" name="isFumante">
                </div>

                <div class="div1">
                    <label for="isDiabetico">É diabetico?</label>
                    <input type="checkbox" value="${paciente.isDiabetico}" name="isDiabetico">
                </div>

                <div class="div1">
                    <label for="isCardiaco">É Cardiaco?</label>
                    <input type="checkbox" value="${paciente.isCardiaco}" name="isCardiaco">
                </div>

                <div class="div1">
                    <div id="button-holder">
                        <button name="salvar" type="submit"> Salvar </button>
                    </div>
                </div>

            </form>
        </section>
    </body>
</html>
