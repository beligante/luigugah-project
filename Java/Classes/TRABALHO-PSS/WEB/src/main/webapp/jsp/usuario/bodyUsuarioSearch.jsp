<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="../comum/Taglibs.jsp" %>
 
<BR><BR>
 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lista de Usuarios
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Nome</th>
								<th>Endereco / Estado / Cidade</th>
								<th>Tipo Usuario</th>
								<th>Tipo Pessoa</th>
								<th>Açoes</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${usuarios}" var="usuario" >
								<tr class="odd gradeA">
									<td><c:out value="${usuario.id}"></c:out></td>
									<td><c:out value="${usuario.nome}" /></td>
									<td>
										<c:out value="${usuario.endereco }" /> / 
										<c:out value="${usuario.estado}" /> /
										<c:out value="${usuario.cidade }" />
									</td>
									<td><c:out value="${usuario.tipoUsuario}" /></td>
									<td><c:out value="${usuario.tipoPessoa}" /></td>
									<td>
										<a href="delete-usuario-by-id?id=<c:out value="${usuario.id}" />" class="btn btn-primary  btn-xs">Deletar</a>
										<a href="update-usuario-by-id?id=<c:out value="${usuario.id}" />" class="btn btn-primary  btn-xs">Atualizar</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
			
<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();
	});
</script>