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
<title>Categorias</title>
</head>
<body>
<h1>Listagem de categorias</h1>
<c:set var="total" value="0" />
<c:forEach var="categoria" items="${categorias}">
	<c:out value="Categoria: ${categoria.getDescricao()} Ponto de função: ${categoria.getPontoDeFuncao()}" /><br />		
</c:forEach>
</body>
</html>