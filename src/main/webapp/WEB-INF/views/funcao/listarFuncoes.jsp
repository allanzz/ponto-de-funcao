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
<title>Funcoes</title>
</head>
<body>
<tag:menu></tag:menu>

	<div class="container">
	<h1>Listagem de Funcoes</h1>
	<form id="filtroFuncoesPorData" method="post" action="/listagemFuncoes">
			<div class="form-group">
				<label for="der" class="form-label">Data Incial:</label>	
				<input type="date" name="dataInicial" pattern="\d{1,2}/\d{1,2}/\d{4}" placeholder="Data Inicial" class="form-control"></div>
					<div class="form-group">
				<label for="der" class="form-label">Data Final:</label>	
				<input type="date" name="dataFinal" pattern="\d{1,2}/\d{1,2}/\d{4}" placeholder="Data Final" class="form-control"></div>
				<br>
				<button type="submit" class="btn btn-primary">Filtrar</button>
	</form>
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Descrição</th>
				<th scope="col">Projeto</th>
				<th scope="col">Tipo</th>
				<th scope="col">Status</th>
				<th scope="col">Responsável</th>
				<th scope="col">Total de Pontos</th>
				<th scope="col">Total  de Pontos Impactados</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="total" value="0" />
			<c:forEach var="funcao" items="${funcoes}">
				<tr>
					
					<td><c:out value="${funcao.getDescricao()}" /></td>
					<td><c:out value="${funcao.getProjeto().getDescricao()}" /></td>
					<td><c:out value="${funcao.getTipo()}" /></td>
					<td><c:out value="${funcao.getStatus()}" /></td>
					<td><c:out value="${funcao.getResponsavel()}" /></td>
					<td><c:out value="${funcao.getPontosDeFuncao()}" /></td>	
					<td><c:out value="${funcao.getPontoDeFuncaoImpactado()}" /></td>												
				</tr>
				<c:set var="total" value="${total+funcao.getPontoDeFuncaoImpactado()}" />
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${total>0 }">
	<c:out value="Total: ${total}" />
	</c:if>
	</div>
</body>
</html>