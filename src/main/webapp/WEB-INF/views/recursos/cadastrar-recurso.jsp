<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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