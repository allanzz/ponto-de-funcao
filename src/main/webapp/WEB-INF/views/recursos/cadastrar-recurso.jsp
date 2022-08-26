<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Cadastro de recursos</title>
</head>
<body>
<h1>Cadastro de recurso</h1>
<c:if test="${param.username!=null }">
	<c:out value="O recurso ${param.username} foi cadastrado com sucesso!" />
</c:if>
<form action="/adiciona-recurso" method="post">
<input type="text" name="nome" width=30 placeholder="Digite o nome do recurso">
<input type="text" name="funcao" width=30 placeholder="Digite a função">
<input type="date" name="dataInicio" width=30 placeholder="Digite a data de inicio">
<input type="submit" value="Enviar" id="button-1"/>
</form>
</body>
</html>