<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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