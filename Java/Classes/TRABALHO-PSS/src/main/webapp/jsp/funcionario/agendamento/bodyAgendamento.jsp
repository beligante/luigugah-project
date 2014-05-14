<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
 
<BR><BR>
 
 <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Lista dos Agendamentos
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Estado</th>
								<th>Cliente</th>
								<th>Telefone</th>
								<th>Funcionario</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<tr class="odd gradeA">
								<td>Em Aberto</td>
								<td>Michel</td>
								<td>(44) 9999-9999</td>
								<td>Alberto</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Aguardando Contato</td>
								<td>Alan</td>
								<td>(44) 3030-3030</td>
								<td>Airton</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Agendado</td>
								<td>Ariadne</td>
								<td>(44) 9999-9999</td>
								<td>Airton</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Aguandando Resultado</td>
								<td>Nicholas</td>
								<td>(44) 3030-3030</td>
								<td>Héverton</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Avaliado</td>
								<td>Peri</td>
								<td>(44) 9999-9999</td>
								<td>Luis</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Concluido</td>
								<td>Gabriela</td>
								<td>(44) 3030-3030</td>
								<td>Luis</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Regeitado</td>
								<td>Victoria</td>
								<td>(43) 9999-9999</td>
								<td>Victor</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
							</tr>
							<tr class="odd gradeA">
								<td>Cancelada</td>
								<td>Adriane</td>
								<td>(43) 3030-3030</td>
								<td>Victor</td>
								<td> <a href="agendamentoDetail" class="btn btn-primary  btn-xs">Editar</a> </td>
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