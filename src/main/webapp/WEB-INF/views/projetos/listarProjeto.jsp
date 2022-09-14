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
<title>Projetos</title>
</head>
<body>
<tag:menu></tag:menu>

	<div class="container">
	<h1>Listagem de projetos</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Descrição</th>
				<th scope="col">Tipo de Projeto</th>
				<th scope="col">Data de Inicio</th>
				<th scope="col">Responsável</th>
				<th scope="col">Tipo de Contagem</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="projeto" items="${projetos}">
				<tr>
					<fmt:formatDate value="${projeto.getDataInicio()}" type="both"
						pattern="dd/MM/yyyy" var="dataFormatada" />
					<td><c:out value="${projeto.getId()}" /></td>
					<td><a href="/detalhe-projeto/${projeto.getId() }"><c:out value="${projeto.getDescricao()}" /></a></td>
					<td><c:out value="${projeto.getTipoProjeto()}" /></td>
					<td>${dataFormatada}</td>
					<td><c:out value="${projeto.getResponsavel()}" /></td>
					<td><c:out value="${projeto.getTipoContagem()}" /></td>
					<td><a href="/excluir-projeto/${projeto.getId()}"><img src="/lixeira-de-reciclagem.png" /></a></td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>