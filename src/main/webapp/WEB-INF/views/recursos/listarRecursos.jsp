<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recursos</title>
</head>
<body>
<h1>Listagem de recursos</h1>
<c:forEach var="recurso" items="${recursos}">
	<c:out value="ID:${recurso.getId()} Nome: ${recurso.getNome()}" />
	<br />
</c:forEach>
</body>
</html>