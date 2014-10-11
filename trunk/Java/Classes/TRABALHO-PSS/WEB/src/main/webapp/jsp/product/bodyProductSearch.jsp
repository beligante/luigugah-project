<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comum/Taglibs.jsp" %>

<%@ page isELIgnored="false" %>
<BR><BR>
 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lista de Produtos
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Tipo</th>
								<th>Dimensao</th>
								<th>Situação</th>
								<th>Valor</th>
								<th>Estado / Cidade</th>
								<th>Açoes</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${produtos}" var="produto" >
								<tr class="odd gradeA">

									<td>${produto.id}</td>
									<td>${produto.tipoProduto}</td>
									<td>${produto.dimensoes} M²</td>
									<td>${produto.situacao}</td>
									<td>R$ ${produto.preco}</td>
									<td>${produto.estado} / ${produto.cidade}</td>
									<td>
										<a href="produto-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Detalhes</a>
										<a href="update-product-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Editar</a>
										<a href="delete-product-by-id?id=${produto.id}" class="btn btn-primary  btn-xs">Deletar</a>
										<c:if test="${isVendaPage}">
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