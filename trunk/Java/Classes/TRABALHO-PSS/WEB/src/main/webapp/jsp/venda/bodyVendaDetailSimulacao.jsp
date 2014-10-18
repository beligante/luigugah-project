<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../comum/Taglibs.jsp" %>

<form class="form-horizontal" role="form">
	<div class="col-lg-12">
		<div class="panel panel-default simulation-result">
		
			<p><strong> Valor original do produto (R$): </strong> ${simulacao.valorOriginal} <p>
			<p><strong> Valor da entrada (R$): </strong> ${simulacao.entrada} <p>
			<p><strong> Valor da parcela (R$): </strong> ${simulacao.valorParcelas}<p>
			<p><strong> Numero de parcelas: </strong> ${simulacao.quantidadeParcelas}<p>
			<p><strong> Juros (%): </strong> ${simulacao.juros}<p>
			<p><strong> Valor final (R$): </strong> ${simulacao.valorFinal}<p>
			<p><strong> Meio de pagamento: </strong> ${checkoutTipoPagamento.label}<p>
			<p><strong> Inicio Pagamento: </strong>  <fmt:formatDate pattern="dd/MM/yyyy" value="${dataPrimeiraParcela}" /><p>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-2">
			<a href="sale-product-by-id?id=${checkoutProduct.id}" class="btn btn-warning">Voltar</a>
		</div>
		<div class="col-md-10">
			<a href="sale-product-contract" class="btn btn-default">Finalizar</a>
		</div>
	</div>
</form>