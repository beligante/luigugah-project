<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ include file="../comum/Taglibs.jsp" %>
<BR><BR>
 
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
							<c:forEach items="${interesses}" var="interesse" >
								<tr class="odd gradeA">

									<td>${interesse.estado}</td>
									<td>${interesse.cliente_id}</td>
									<td>${interesse.produto_id}</td>
									<td>${interesse.data_cadastro}</td>
									<td>
										<a href="produto-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Detalhes</a>
										<a href="update-product-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Editar</a>
										<a href="delete-product-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Deletar</a>
										<c:if test="${isInteresseVendaPage}">
											<a href="sale-product-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Vender</a>
										</c:if>
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