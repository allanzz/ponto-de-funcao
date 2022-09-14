<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<title>Usuários-Listagem</title>
</head>
<body>
<tag:menu></tag:menu>

	<div class="container">
	<h1>Listagem de Usuarios</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Nome</th>				
				<th scope="col">Função</th>
				<th scope="col">Data de Inicio</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<fmt:formatDate value="${usuario.getDataInicio()}" type="both"
						pattern="dd/MM/yyyy" var="dataFormatada" />
					<td><c:out value="${usuario.getId()}" /></td>
					<td><a href="/detalhe-projeto/${projeto.getId() }"><c:out value="${usuario.getNome()}" /></a></td>
					<td><c:out value="${usuario.getFuncao()}" /></td>
					<td>${dataFormatada}</td>					
					<td><a href="/remove-usuario/${usuario.getId()}"><img src="/lixeira-de-reciclagem.png" /></a></td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>