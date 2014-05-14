<%@include file="Taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<tiles:insertAttribute name="title" ignore="true" />
	</title>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/client.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
	
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.css">
	<link type="text/css" rel="stylesheet" href="css/client.css">
	<link type="text/css" rel="stylesheet" href="css/dataTables.bootstrap.css">
</head>
<body>
	<div id="main-container" class="container">
		<div class="top-bar">
			<tiles:insertAttribute name="top-bar" />
		</div>
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="body">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>