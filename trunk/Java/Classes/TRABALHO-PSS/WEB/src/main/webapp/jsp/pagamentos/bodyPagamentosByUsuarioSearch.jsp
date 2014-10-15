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
								<th>Codigo Negocio</th>
								<th>Vencimento</th>
								<th>Valor</th>
								<th>Boleto</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${faturas}" var="fatura" >
								<tr class="odd gradeA">
									<td>${fatura.id}</td>
									<td>${fatura.idPagamento}</td>
									<td><fmt:formatDate value="${fatura.vencimento}" pattern="dd/MM/yyyy"/></td>
									<td><fmt:formatNumber 
											maxFractionDigits="2" 
											value="${fatura.valor}" 
											type="currency"
											currencySymbol="R$"></fmt:formatNumber></td>
									<td>
										<a href="${fatura.linkBoleto}" target="_blank">
											Download <img style="width:22px" alt="boleto" src="img/PDF.png">
										</a>
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