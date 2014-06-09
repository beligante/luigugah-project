<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro Paciente</title>
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="stylesheet" type="text/css" href="css/busca-consulta.css">

    </head>
    <body>
        <header>
            <%@include file="../comum/header.jsp" %>
            <%@include file="../comum/menu.jsp" %>
        </header>

        <section id="container">		
            <form id="form" method="POST" action="buscaConsulta">

                <div class="div1">
                    <label class="title">Buscar Consulta</label> 
                </div>

                <div class="div1"> 
                    <input class="rounded-border" name="query" type="date">
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
                        <div id="data-da-consulta">
                            <label>Data da Consulta</label>
                        </div>
                        <div id="medico">
                            <label>Médico</label>
                        </div>
                    </div>
                </div>

                <c:if test="${not empty consultas}">
                    <div class="div1">
                        <div id="table-body">
                            <c:forEach items="${consultas}" var="consulta" varStatus="count">
                                <div id="table-row" <c:if test="${count.count eq fn:length(consultas)}">class="last"</c:if>>
                                        <div id="acoes">
                                            <a id="edit-btn" class="button" href="cadastroConsulta?editId=${consulta.id}">Editar</a>
                                        <a class="button" href="cadastroConsulta?deleteId=${consulta.id}" >Remover</a>
                                    </div>
                                    <div id="nome-paciente">
                                        <label>${consulta.paciente.nome}</label>
                                    </div>
                                    <div id="data-da-consulta">
                                        <label>
                                            <fmt:formatDate pattern="dd/MM/yyyy" value="${consulta.dataConsulta}" />
                                        </label>
                                    </div>
                                    <div id="medico">
                                        <label>${consulta.medico.nome}</label>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if> 
                <c:if test="${empty consultas}">
                   <div class="div1">
                        <div id="table-body">
                            <h1> Não existem registros</h1>
                        </div>
                   </div>
                </c:if>
            </form>
        </section>
    </body>
</html>
