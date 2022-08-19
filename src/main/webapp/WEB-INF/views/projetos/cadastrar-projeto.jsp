<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de projeto</title>
</head>
<body>
<h1>Cadastro de Projeto</h1>
<c:if test="${param.descricao!=null }">
	<c:out value="O projeto ${param.descricao} foi cadastrado com sucesso!" />	
</c:if>
<form action="/adiciona-projeto" method="post">
<input type="text" name="descricao" width=30 placeholder="Nome do Projeto">
<input type="text" name="responsavel" width=30 placeholder="Responsavel pelo projeto">
<input type="date" name="dataInicio" width=30 placeholder="Digite a data de inicio">
<input type="submit" value="Enviar" id="button-1"/>
</form>
</body>
</html>