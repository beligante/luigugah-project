<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro Paciente</title>
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="stylesheet" type="text/css" href="css/busca-paciente.css">

    </head>
    <body>
        <header>
            <%@include file="../comum/header.jsp" %>
            <%@include file="../comum/menu.jsp" %>
        </header>

        <section id="container">		
            <form id="form" method="POST" action="buscaPaciente">

                <div class="div1">
                    <label class="title">Buscar Paciente</label> 
                </div>

                <div class="div1"> 
                    <input class="rounded-border" name="query" type="search">
                    <button for="query" type="submit">Buscar</button>
                </div>

                <div class="cropped-border"></div>

                <div class="div1">
                    <div id="table-header">
                        <div id="acoes">
                            <label>Ações</label>
                        </div>
                        <div id="nome-paciente">
                            <label>Nome Paciente</label>
                        </div>
                        <div id="rg">
                            <label>RG</label>
                        </div>
                        <div id="telefone">
                            <label>Telefone</label>
                        </div>
                    </div>
                </div>

                <c:if test="${not empty pacientes}">
                    <div class="div1">
                        <div id="table-body">
                            <c:forEach items="${pacientes}" var="paciente" varStatus="count">
                                <div id="table-row" 
                                     <c:if test="${count.count eq fn:length(pacientes)}">class="last"</c:if>>
                                         <div id="acoes">
                                             <a class="button" href="cadastroPaciente?editId=${paciente.id}">Editar</a>
                                         <a class="button" href="cadastroPaciente?deleteId=${paciente.id}">Remover</a>
                                     </div>
                                     <div id="nome-paciente">
                                         <label>${paciente.nome}</label>
                                     </div>
                                     <div id="rg">
                                         <label>${paciente.rg}</label>
                                     </div>
                                     <div id="telefone">
                                         <label>${paciente.telefone}</label>
                                     </div>
                                </div>

                            </c:forEach>
                        </div>
                    </div>
                </c:if>
                <c:if test="${empty pacientes}">

                    <h1> Nenhum registro encontrado</h1>
                </c:if>

            </form>
        </section>
    </body>
</html>
