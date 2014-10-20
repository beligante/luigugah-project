<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../comum/Taglibs.jsp" %> 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lista de Intereses
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Estado</th>
								<th>Cliente</th>
								<th>Produto</th>
								<th>Data</th>
								<th>Açoes</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${interessesVendaVO}" var="interesse" >
								<tr class="odd gradeA">

									<td>${interesse.tipoSituacao}</td>
									<td>${interesse.interesseVenda.clienteId}</td>
									<td>${interesse.interesseVenda.produtoId}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${interesse.interesseVenda.dataCadastro}" /></td>
									<td>
										<a href="sales-intrest-manager-update?id=${interesse.interesseVenda.id}" class="btn btn-primary  btn-xs">Editar</a>
										<a href="sales-intrest-manager-delete?id=${interesse.interesseVenda.id}" class="btn btn-primary  btn-xs">Deletar</a>
										<a href="sale-product-by-id?id=${interesse.interesseVenda.produtoId}&clientId=${interesse.interesseVenda.clienteId}" class="btn btn-primary  btn-xs">Vender</a>
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