<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="../comum/Taglibs.jsp" %>
 

<form class="form-horizontal" action="sale-product-by-id-submit"  method="POST" role="form">

	<BR><BR>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Cliente</label>
		<div class="col-xs-5">
			<select name="cliente" class="form-control">
				<c:forEach var="cliente" items="${clientes }">
					<option value="${cliente.id }">${cliente.nome }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<BR><BR>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Vendedor</label>
		<div class="col-xs-5">
			<select name="vendedor" class="form-control">
				<c:forEach var="vendedor" items="${vendedores }">
					<option value="${vendedor.id }">${vendedor.nome }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<BR><BR>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Valor do Imovel</label>
		<div class="col-xs-5">
			R$ ${produto.preco}
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Valor de entrada (R$)</label>
		<div class="col-xs-5">
			<input type="number" name="entrada" class="form-control" placeholder="10.000,00 R$" autocomplete="off" >
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Quantidade de parcelas</label>
		<div class="col-xs-5">
			<input type="number" name="parcelas" class="form-control" placeholder="5" autocomplete="off" >
		</div>
	</div>

	<BR><BR>

	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Forma de pagamento</label>
		<div class="col-xs-5">
			<select name="tipoPagamento" class="form-control">
				<c:forEach items="${tiposPagamento}" var="tipoPagamento">
					<option value="${tipoPagamento}">${tipoPagamento.label }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Dia para vencimento boleto</label>
		<div class="col-xs-5">
			<input type="number" name="vencimentoBoleto" >
		</div>
	</div>
	
	<BR><BR>
	
	<input type="hidden" name="produto" value="${produto.id}">
	
	<div class="form-group">
		<div class="col-md-2">
			<a href="catalog-search"  class="btn btn-warning">Voltar</a>
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary">Efetuar Simulação</button>
		</div>
	</div>

</form>