<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Projetos</title>
</head>
<body>
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
					<td><a href="#"><c:out value="${projeto.getDescricao()}" /></a></td>
					<td><c:out value="${projeto.getTipoProjeto()}" /></td>
					<td>${dataFormatada}</td>
					<td><c:out value="${projeto.getResponsavel()}" /></td>
					<td><c:out value="${projeto.getTipoContagem()}" /></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>