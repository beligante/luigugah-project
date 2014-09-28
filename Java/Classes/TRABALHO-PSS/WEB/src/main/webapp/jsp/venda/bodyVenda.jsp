<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
 
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
								<th>Valor</th>
								<th>Estado / Cidade</th>
								<th>Açoes</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${produtos}" var="produto" >
							<tr class="odd gradeA">
								<td><c:out value="${produto.id}"></c:out></td>
								<td><c:out value="${produto.tipoProduto}" /></td>
								<td><c:out value="${produto.dimensoes }" /> M²</td>
								<td>R$ <c:out value="${produto.preco}" /></td>
								<td><c:out value="${produto.estado}" /> / <c:out value="${produto.cidade}" /></td>
								<td>
									<a href="productDetail?=<c:out value="${produto.id}" />" class="btn btn-primary  btn-xs">Detalhes</a> 
									<a href="vendaDetail?id=<c:out value="${produto.id}" />" class="btn btn-danger  btn-xs">Vender</a> 
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