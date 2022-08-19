<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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