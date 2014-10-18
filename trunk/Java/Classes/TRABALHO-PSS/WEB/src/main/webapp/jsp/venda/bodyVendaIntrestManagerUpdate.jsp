<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../comum/Taglibs.jsp" %>

<form class="form-horizontal" action="sales-intrest-manager-update-submit"  method="POST" role="form">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row">
				<div class="col-md-1">
					<label>Data de Registro:</label>
				</div>
				<div class="col-md-11">
					<fmt:formatDate pattern="dd/MM/yyyy" value="${interesseVend.dataCadastro}" />
				</div>
			</div>	
			
			<div class="row">
				<div class="col-md-1">
					<label>Cliete:</label>
				</div>
				<div class="col-md-11">
					${interesseVend.clienteId}
				</div>
			</div>	
			
			<div class="row">
				<div class="col-md-1">
					<label>Produto:</label>
				</div>
				<div class="col-md-11">
					${interesseVend.produtoId}
				</div>
			</div>	
			
			<div class="row">
				<div class="col-md-1">
					<label>Situação</label>
				</div>
				<div class="col-md-11">
					<select name="interesseSituacao">
			    		<option value="PENDENTE" <c:if test="${interesseVendHist.situacao == 'PENDENTE'}">selected="selected"</c:if> >Pendente</option>
			    		<option value="CONTATO_EFETUADO"<c:if test="${interesseVendHist.situacao == 'CONTATO_EFETUADO'}">selected="selected"</c:if>>Contato efetuado</option>
			    		<option value="AGUARDANDO_RESPOSTA" <c:if test="${interesseVendHist.situacao == 'AGUARDANDO_RESPOSTA'}">selected="selected"</c:if>>Aguardando resposta</option>
			    		<option value="VENDIDO" <c:if test="${interesseVendHist.situacao == 'VENDIDO'}">selected="selected"</c:if>>Vendido</option>
			    		<option value="CANCELADO" <c:if test="${interesseVendHist.situacao == 'CANCELADO'}">selected="selected"</c:if>>Cancelado</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-md-1">
					<label>Descrição</label>
				</div>
				<div class="col-md-6">
					<textarea name="interesseDescricao" class="form-control" rows="3"></textarea>
				</div>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-9"></div>
				<div class="col-md-1">
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-floppy-disk"></span> Salvar
					</button>
				</div>
				<div class="col-md-1">	
					<a href="sales-intrest-manager" type="button" class="btn btn-warning">
						<span class="glyphicon glyphicon-chevron-left"></span>  Cancelar
					</a>

				</div>
			</div>
		</div>
	</div>
	
	<input type="hidden" name="interesseId" value="${interesseVend.id}"></input>
	
</form>

<BR>

<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Histórico</h3>
	</div>
	<div class="panel-body">
		<table class="table table-striped">
      <thead>
        <tr>
          <th>Data</th>
          <th>Situação</th>
          <th>Descrição</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach items="${listInteresseVendHist}" var="historico">
		  
		  <tr>  
       		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${historico.dataOcorrencia}" /></td>
       		<td>${historico.situacao}</td>
       		<td>${historico.descricao}</td>
          </tr>
            
        </c:forEach>
      </tbody>
    </table>
	</div>
</div>