<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
							<tr class="odd gradeA">
								<td>127</td>
								<td>Apartamento</td>
								<td>80 M²</td>
								<td>R$ 140.000.000,00</td>
								<td>Paraná / Maringá</td>
								<td> 
									<a href="productClienteDetail" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>124</td>
								<td>Casa</td>
								<td>100 M²</td>
								<td>R$ 220.000.000,00</td>
								<td>Paraná / Maringá</td>
								<td> 
									<a href="productClienteDetail" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>125</td>
								<td>Galpão</td>
								<td>90 M²</td>
								<td>R$ 200.000.000,00</td>
								<td>Paraná / Maringá</td>
								<td> 
									<a href="productClienteDetail" class="btn btn-primary  btn-xs">Detalhes</a> 
								</td>
							</tr>
							<tr class="odd gradeA">
								<td>126</td>
								<td>Salao Comercial</td>
								<td>120 M²</td>
								<td>R$ 110.000.000,00</td>
								<td>Paraná / Maringá</td>
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