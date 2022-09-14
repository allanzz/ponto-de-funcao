<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/style.css">
<title>Login</title>
<style type="text/css">
	.login{
	width:50%;
	padding:80px;
	margin:auto;
	margin-top:10%;
	background-color:rgb(211,211,211);	
	border:1px solid;
	border-radius:40%;
}
</style>
</head>
<body>
<div class="container login">
<form action="/login" method="post">
	<input type="text" name="username" class="form-control" placeholder="Nome do usuário" /><br>
	<input type="password" name="password" class="form-control" placeholder="Digite a senha" /><br>
	<div class="text-center">
	<button type="submit" class="btn btn-primary" value="Enviar">Enviar</button>
	</div>
</form>
</div>
</body>
</html>