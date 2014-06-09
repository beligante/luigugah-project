<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro Paciente</title>
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="stylesheet" type="text/css" href="css/cadastro-consulta.css">

    </head>
    <body>
        <header>
            <%@include file="../comum/header.jsp" %>
            <%@include file="../comum/menu.jsp" %>
        </header>

        <section id="container">		
            <form id="form" method="POST" action="cadastroConsulta">
                <div class="div1">
                    <label class="title">Cadastro de Consulta</label> 
                </div>
                <c:if test="${not empty consulta}">
                    <input type="hidden" value="${consulta.id}" name="consultaId">
                </c:if>
                <div class="div1">
                    <label for="dataConsulta">Data consulta</label> 
                    <input required class="first" name="dataConsulta" type="date"
                    value="<fmt:formatDate pattern="yyyy-MM-dd" value="${consulta.dataConsulta}" />">
                </div>

                <div class="div1">
                    <label for="horaConsulta">Hora consulta</label> 
                    <input required class="last" name="horaConsulta" type="time"
                    value="<fmt:formatDate pattern="HH:mm" value="${consulta.dataConsulta}" />">
                </div>

                <div class="div1">
                    <label for="medicoId">Medico</label>
                    <select class="first" name="medicoId" id="tipoConsulta">
                        <c:forEach items="${medicos}" var="medico">
                            <option 
                                <c:if test="${not empty consulta}">
                                <c:if test="${consulta.medico.id eq medico.id}">
                                        selected="selected"
                                    </c:if> 
                                       </c:if>
                                value="${medico.id}">
                                    ${medico.nome}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="div1">
                    <label for="pacienteId">Paciente</label>
                    <select name="pacienteId" id="tipoConsulta">
                        <c:forEach items="${pacientes}" var="paciente">
                            <option 
                                    
                                <c:if test="${not empty consulta}">
                                <c:if test="${consulta.paciente.id eq paciente.id}">
                                        selected="selected"
                                </c:if> </c:if> 
                                    value="${paciente.id}">
                                        ${paciente.nome}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="div1">
                    <label for="tipoConsulta">Tipo da Consulta</label>
                    <select class="last" name="tipoConsulta" id="tipoConsulta">
                        <option 
                            <c:if test="${not empty consulta}">
                                <c:if test="${consulta.tipoConsulta eq 'NORMAL'}">selected="selected"</c:if>
                            </c:if>
                                value="NORMAL">Normal</option>
                        <option 
                            <c:if test="${not empty consulta}">
                                <c:if test="${consulta.tipoConsulta eq 'RETORNO'}"> selected="selected"</c:if>
                            </c:if> value="RETORNO">Retorno</option>
                    </select>
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
