<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de projeto</title>
</head>
<body>
<h1>Detalhes de Projeto</h1>
<fmt:formatDate value="${projeto.getDataInicio()}" type="both" pattern="dd/MM/yyyy" var="dataFormatada"/>
<c:out value="Nome do projeto: ${projeto.getDescricao()} | Responsável:${projeto.getResponsavel()} | Data de Inicio:${dataFormatada}" />

<h2>Adicionar tarefas</h2>
<form action=<c:out value="/adiciona-tarefa/${projeto.getId()}" /> method="post">
<input type="text" name="descricao" width=30 placeholder="Nome do Projeto">
<input type="text" name="responsavel" width=30 placeholder="Responsavel pelo projeto">
<input type="hidden" name="projeto_id" value="${projeto.getId()}" />
<select name="categoria">
	<c:forEach var="categoria" items="${categorias}">
		<option value="${categoria.getId()}"><c:out value="${categoria.getDescricao()}" /></option>
	</c:forEach>
</select>
<input type="submit" value="Enviar" id="button-1"/> 
</form>
<c:set var="total" value="0" />
<c:forEach var="tarefa" items="${projeto.getTarefas()}">
	<c:out value="Descrição da Tarefa: ${tarefa.getDescricao()} Categoria:${tarefa.getCategoria().getDescricao()} Responsável: ${tarefa.getRecursoResponsavel()}"/><br />
	<c:set var="total" value="${total+tarefa.getCategoria().getPontoDeFuncao()}" />
</c:forEach>
<c:out value="${total}" />
</body>
</html>