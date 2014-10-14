<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comum/Taglibs.jsp" %>

<%@ page isELIgnored="false" %>
<BR><BR>
 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Vendas Efetuadas
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Vendedor</th>
								<th>Cliente</th>
								<th>Valor Final</th>
								<th>Meio de Pagamento</th>
								<th>Açoes</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${vendas}" var="venda" >
								<tr class="odd gradeA">
									<td>${venda.negocio.id}</td>
									<td>${venda.vendedor.nome}</td>
									<td>${venda.comprador.nome}</td>
									<td><fmt:formatNumber 
											maxFractionDigits="2" 
											value="${venda.negocio.valorFinalTotal}" 
											type="currency"
											currencySymbol="R$"></fmt:formatNumber> </td>
									<td>${venda.meioPagamento.label}</td>
									<td>
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