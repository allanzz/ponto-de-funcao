<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de projeto</title>
</head>
<body>
<h1>Cadastro de Projeto</h1>
<form action="/adiciona-projeto" method="post">
<input type="text" name="descricao" value="${projeto.getDescricao()}" width=30 placeholder="Nome do Projeto" readonly="readonly">
<input type="text" name="responsavel" value="${projeto.getResponsavel()} width=30 placeholder="Responsavel pelo projeto" readonly="readonly">
<input type="date" name="dataInicio" value="${projeto.getDataInicio()} width=30 placeholder="Digite a data de inicio" readonly="readonly">
</form>

<c:if test="${param.projetoId!=null}">
<form action="/adiciona-tarefa" method="post">
<input type="text" name="descricao" width=30 placeholder="Nome do Projeto">
<input type="text" name="responsavel" width=30 placeholder="Responsavel pelo projeto">
<input type="date" name="dataInicio" width=30 placeholder="Digite a data de inicio">
<input type="submit" value="Enviar" id="button-1"/>
</form>
</c:if>
</body>
</html>