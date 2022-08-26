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
<title>Cadastro de projeto</title>
</head>
<body>
	<h1>Detalhes de Projeto</h1>
	<fmt:formatDate value="${projeto.getDataInicio()}" type="both"
		pattern="dd/MM/yyyy" var="dataFormatada" />
	<c:out
		value="Nome do projeto: ${projeto.getDescricao()} | Responsável:${projeto.getResponsavel()} | Data de Inicio:${dataFormatada}" />

	<h2>Adicionar tarefas</h2>
	<div class="form-group">
	<form action=<c:out value="/adiciona-tarefa/${projeto.getId()}" />
		method="post">
		<input type="text" name="descricao" width=30
			placeholder="Nome do Projeto"> <input type="text"
			name="recursoResponsavel" width=30 placeholder="Responsavel pelo projeto">
		<input type="hidden" name="projeto_id" value="${projeto.getId()}" />
		<select name="categoria">
			<c:forEach var="categoria" items="${categorias}">
				<option value="${categoria.getId()}"><c:out
						value="${categoria.getDescricao()}" /></option>
			</c:forEach>
		</select> <input type="submit" value="Enviar" id="button-1" />
	</form>
	</div>
	<c:set var="total" value="0" />
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Descrição</th>
				<th scope="col">Categoria</th>
				<th scope="col">Responsável</th>
				<th scope="col">Pontos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tarefa" items="${projeto.getTarefas()}">
				<tr>
					<td>${tarefa.getDescricao()}</td>
					<td>${tarefa.getCategoria().getDescricao()}</td>
					<td>${tarefa.getRecursoResponsavel()}</td>
					<td>${tarefa.getCategoria().getPontoDeFuncao()}</td>
					<c:set var="total"
						value="${total+tarefa.getCategoria().getPontoDeFuncao()}" />
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:out value=" Total de Pontos: ${total}" />
</body>
</html>