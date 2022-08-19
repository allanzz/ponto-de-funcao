<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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