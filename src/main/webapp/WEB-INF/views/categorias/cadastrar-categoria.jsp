<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Cadastro de categoria</title>
</head>
<body>
	<h1>Cadastro de Categoria</h1>
	<c:if test="${param.nome!=null }">
		<c:out value="A categoria foi cadastrada com sucesso!" />
	</c:if>
	<form action="/adiciona-categoria" method="post">
		<input type="text" name="descricao" width=70
			placeholder="Titulo da categoria"> <input type="text"
			name="PontoDeFuncao" width=70
			placeholder="Quantidade pontos de função"> <input
			type="submit" value="Enviar" id="button-1" />
	</form>
</body>
</html>