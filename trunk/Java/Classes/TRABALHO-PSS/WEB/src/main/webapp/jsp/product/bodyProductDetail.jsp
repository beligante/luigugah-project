<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="product-detail-page container">
	<div class="col-md-9">
		<div class="thumbnail">
			<img class="img-responsive" src="${produto.linkFoto}" alt="foto produto">

			<div class="caption-full">
				<h4 class="pull-right">R$ ${produto.preco}</h4>
				<h4>
					<a href="#">${produto.tipoProduto} -  ${produto.dimensoes} M²</a>
				</h4>
				<p>
					<span class="destaque-text">Endereço:</span> ${produto.endereco}
				</p>
				<p>
					<span class="destaque-text">Bairro:</span> ${produto.bairro}
				</p>
				<p>
					<span class="destaque-text">Cidade / Estado:</span> ${produto.cidade} / ${produto.estado}
				</p>
				<p>
					<span class="destaque-text">Descricao:</span> ${ produto.descricao}
				</p>
				<p></p>
			</div>
		</div>

	</div>
</div>