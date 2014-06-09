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
        <link rel="stylesheet" type="text/css" href="css/busca-prontuario.css">

    </head>
    <body>
        <header>
            <%@include file="../comum/header.jsp" %>
            <%@include file="../comum/menu.jsp" %>
        </header>

        <section id="container">		
            <form id="form" method="POST" action="buscaProntuario">

                <div class="div1">
                    <label class="title">Buscar Prontuario</label> 
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
                        <div id="data-ultima-modificacao">
                            <label>Data Ultima Modificação</label>
                        </div>
                        <div id="hora-ultima-modificaca">
                            <label>Hora Ultima Modificação</label>
                        </div>
                    </div>
                </div>
                <c:if test="${not empty prontuarios}">
                    <div class="div1">
                        <div id="table-body">
                            <c:forEach items="${prontuarios}" var="prontuario" varStatus="count">
                                <div id="table-row" <c:if test="${count.count eq fn:length(prontuarios)}">class="last"</c:if>>
                                        <div id="acoes">
                                            <a class="button" href="cadastroProntuario?deleteId=${prontuario.id}">Remover</a>
                                    </div>
                                    <div id="nome-paciente">
                                        <label>${prontuario.paciente.nome}</label>
                                    </div>
                                    <div id="data-ultima-modificacao">
                                        <label><fmt:formatDate pattern="dd/MM/yyyy" value="${prontuario.dataModificacao}"/></label>
                                    </div>
                                    <div id="hora-ultima-modificaca">
                                        <label><fmt:formatDate pattern="HH:mm" value="${prontuario.dataModificacao}"/></label>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${empty prontuarios}">
                    <h1> Nenhum registro encontrado</h1>
                </c:if>

            </form>
        </section>
    </body>
</html>
