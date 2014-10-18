<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lista de Vendas Efetuadas
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Cliente</th>
								<th>Funcionario</th>
								<th>Valor</th>
								<th>Estado</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<tr class="odd gradeA">
								<td>127</td>
								<td>Michel</td>
								<td>Alberto</td>
								<td>R$ 140.000.000,00</td>
								<td>Pendente de pagamento</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
									<a href="#1" class="btn btn-danger  btn-xs">Cancelar</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>223</td>
								<td>Teresa Cristina</td>
								<td>Alberto</td>
								<td>R$ 200.000.000,00</td>
								<td>Cancelada</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>323</td>
								<td>Rita</td>
								<td>Alberto</td>
								<td>R$ 350.000.000,00</td>
								<td>Pago</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>423</td>
								<td>Pedro</td>
								<td>Alberto</td>
								<td>R$ 354.000.000,00</td>
								<td>Pago</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>233</td>
								<td>Otavio</td>
								<td>Alberto</td>
								<td>R$ 245.000.000,00</td>
								<td>Pago</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>23</td>
								<td>Rosana</td>
								<td>Alberto</td>
								<td>R$ 167.000.000,00</td>
								<td>Pendente de pagamento</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
									<a href="#1" class="btn btn-danger  btn-xs">Cancelar</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>122</td>
								<td>Luis</td>
								<td>Alberto</td>
								<td>R$ 200.000.000,00</td>
								<td>Cancelada</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>	
							<tr class="odd gradeA">
								<td>125</td>
								<td>Rosana</td>
								<td>Alberto</td>
								<td>R$ 167.000.000,00</td>
								<td>Pendente de pagamento</td>
								<td> 
									<a href="#1" class="btn btn-primary  btn-xs">Detalhes</a> 
									<a href="#1" class="btn btn-danger  btn-xs">Cancelar</a> 
								</td>
							</tr>		
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