<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
	<header>
		<div class="banner">
			<h2>Sistema de Gerenciamento de Clinicas</h2>
			<h4>Faça seu login</h4>
		</div>
	</header>
	<section class="container">
		<div class="card card-sizing">
                    <form class="form-signin" role="form" action="login" method="POST">
				
				<img class="rounded-medium-img" alt="Helth Symbol" src="images/helth-symbol-cpy.png" />
				<label class="card-header">Saúde & CIA</label>
				<input id="email" name="user" class="first input-style form-control" placeholder="User" required autofocus>
				<input id="password" name="password" type="password" class="last form-control" placeholder="Password" required>
				<a class="forgot-text" href="forgot.html"> Esqueceu sua senha? Clique aqui! </a>
				<div id="submitButton">
					<button class="" type="submit">Sign in</button>
				<div>
			</form>
		</div>

    </section>
	
	</body>
</html>