<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<img class="logo-header" alt="Helth Symbol" src="images/helth-symbol.png" />
<div class="banner">
    <h2>Sistema de Gerenciamento de Clinicas</h2>
    <h4>Version: 1.0.0 </h4>
</div>
<div class="user-informations">
    <div class="user-name">Usuario Logado: <span>${usuarioLogado.nome}</span></div>
    <div class="user-type">Função: <span>${usuarioLogado.funcao}</span> </div>
    <img class="user-pic" alt="User Picture" src="images/user-pic.png" />
</div>