<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<form class="form-horizontal" role="form">

	<BR><BR>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Tipo pessoa</label>
		<div class="col-sm-10">
			<label>
				<input type="radio" name="optionsRadios" id="optionsRadios1" value="F" checked> Fisica
			</label>
			<label>
				<input type="radio" name="optionsRadios" id="optionsRadios1" value="J" checked> Juridica
			</label>
		</div>
	</div>
	
	<BR><BR>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Qual o valor do imovel</label>
		<div class="col-xs-5">
			<input type="text" class="form-control" placeholder="10.000,00 R$" autocomplete="off" style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); padding-right: 0px; background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat no-repeat;">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Valor de entrada</label>
		<div class="col-xs-5">
			<input type="text" class="form-control" placeholder="10.000,00 R$" autocomplete="off" style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); padding-right: 0px; background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat no-repeat;">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Quantidade de parcelas</label>
		<div class="col-xs-5">
			<input type="text" class="form-control" placeholder="5" autocomplete="off" style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=); padding-right: 0px; background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat no-repeat;">
		</div>
	</div>

	<BR><BR>

	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Estado onde o produto se encontra</label>
		<div class="col-xs-5">
			<select class="form-control">
				<option value="">PR</option>
				<option value="">SP</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Cidade onde o produto se encontra</label>
		<div class="col-xs-5">
			<select class="form-control">
				<option value="">Maringá</option>
				<option value="">Paiçandu</option>
				<option value="">Sarandi</option>
			</select>
		</div>
	</div>
	
	<BR><BR>
	
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Forma de pagamento</label>
		<div class="col-xs-5">
			<select class="form-control">
				<option value="">Cartão</option>
				<option value="">Boleto mensal</option>
			</select>
		</div>
	</div>
	
	<BR><BR>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Simular compra</button>
		</div>
	</div>
</form>