<%@include file="Taglibs.jsp"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">SAEI</a>
        </div>
		
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="wellcome">Home</a></li>
				<li><a href="register">Cadastro</a></li>
				<li><a href="simulation">Simula��o</a></li>
				<li><a href="saletous">Venda para N�s</a></li>
			</ul>
			<form class="navbar-form navbar-right" role="form">
				<div class="form-group">
					<input type="text" placeholder="Email" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" class="form-control">
				</div>
				<a href="funcionario" class="btn btn-success">Sign in</a>
			</form>
        </div><!--/.navbar-collapse -->
      </div>
 </div>