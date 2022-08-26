<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Recursos</title>
</head>
<body>
<h1>Listagem de projetos</h1>
<c:forEach var="projeto" items="${projetos}">
	<fmt:formatDate value="${projeto.getDataInicio()}" type="both" pattern="dd/MM/yyyy" var="dataFormatada"/>
	<c:out value="ID: ${projeto.getId()} Nome: ${projeto.getDescricao()} Responsável:${projeto.getResponsavel()} Data de Inicio:${dataFormatada} " />
	<br />
</c:forEach>
</body>
</html>