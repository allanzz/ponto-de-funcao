<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<title>Cadastro de Usuário</title>
</head>
<body>
<tag:menu></tag:menu>
<div class="container">
<h1>Cadastro de Usuário</h1>
<c:if test="${param.username!=null }">
	<c:out value="O usuário ${param.username} foi cadastrado com sucesso!" />
</c:if>
<form action="/novo-usuario" method="post">
<input type="text" class="form-control" name="username" width=30 placeholder="Digite o username"><br />
<input type="text" class="form-control" name="nome" width=30 placeholder="Digite o nome do Usuário"><br />
<input type="text" class="form-control" name="funcao" width=30 placeholder="Digite a função"><br />
<input type="date" class="form-control" name="dataInicio" width=30 placeholder="Digite a data de inicio"><br />
<input type="password" class="form-control" name="password" placeholder="Digite a senha"/><br />
<input type="submit" class="btn btn-primary" value="Enviar" id="button-1"/>
</form>
</div>
</body>
</html>