<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
 
<BR><BR>
 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lista de Pagamentos
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Codigo</th>
								<th>Funcionario</th>
								<th>Data</th>
								<th>Valor</th>
								<th>Forma Pgto</th>
								<th>Açoes</th>
							</tr>
						</thead>
						<tbody>
							<tr class="odd gradeA">
								<td>127</td>
								<td>Luis</td>
								<td>05/12/2012</td>
								<td>R$ 140.000.000,00</td>
								<td>Cartao (68x)</td>
								<td> 
									<a href="productClienteDetail" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>130</td>
								<td>Luis</td>
								<td>05/06/2013</td>
								<td>R$ 300.000.000,00</td>
								<td>Boleto (68x)</td>
								<td> 
									<a href="productClienteDetail" class="btn btn-primary  btn-xs">Detalhes</a> 
									<a href="#" class="btn btn-warning btn-xs">Boleto deste mês</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>167</td>
								<td>Luis</td>
								<td>13/08/2013</td>
								<td>R$ 230.000.000,00</td>
								<td>Cartao (68x)</td>
								<td> 
									<a href="productClienteDetail" class="btn btn-primary  btn-xs">Detalhes</a> 
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