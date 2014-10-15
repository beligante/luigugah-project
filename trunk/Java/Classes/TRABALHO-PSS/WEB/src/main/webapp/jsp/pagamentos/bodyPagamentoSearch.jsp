<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comum/Taglibs.jsp" %>

<%@ page isELIgnored="false" %>
<BR><BR>
 
 <div class="row">
	<div class="col-lg-12">
		<form action="pagamentos-search-submit" method="POST">
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">Selecione o Usuario</label>
				<div class="col-xs-5">
					<select name="idUsuario" onchange="this.form.submit()" class="form-control">
						<option value="">Selecione</option>
						<c:forEach var="usuario" items="${usuarios}">
							<option value="${usuario.id}">${usuario.id} - ${usuario.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</form>
	</div>
</div>