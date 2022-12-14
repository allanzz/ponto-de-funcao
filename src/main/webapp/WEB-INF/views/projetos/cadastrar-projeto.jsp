<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Cadastro de projeto</title>
</head>
<body>
<tag:menu></tag:menu>
<div class="container">
<h1>Cadastro de Projeto</h1>
<c:if test="${param.descricao!=null }">
	<c:out value="O projeto ${param.descricao} foi cadastrado com sucesso!" />	
</c:if>
<form action="/adiciona-projeto" method="post">
<input type="text" name="descricao" class="form-control" width=30 placeholder="Nome do Projeto"><br />
<input type="text" name="responsavel" class="form-control" width=30 placeholder="Responsavel pelo projeto"><br />
<label for="tipoContagem" class="form-label">Tipo de Contagem:</label>
<select name="tipoContagem" class="form-select">
	<option value="Detalhada">Detalhada</option>
	<option value="Estimada">Estimada</option>
</select>
<br />
<label for="tipoProjeto" class="form-label">Tipo de projeto:</label>
<select name="tipoProjeto" class="form-select">
	<option value="Desenvolvimento">Desenvolvimento</option>
	<option value="Melhoria">Melhoria</option>
</select>
<br />
<label for="artefato" class="form-label">Artefatos da análise:</label><br />
<textarea rows="5" cols="30" name="artefato" class="form-control"></textarea><br />
<label for="comentarios" class="form-label">Comentarios:</label><br />
<textarea rows="5" cols="30" name="comentarios" class="form-control"></textarea><br />
<input type="date" name="dataInicio" width=30 placeholder="Digite a data de inicio" class="form-control"><br />
<input type="submit" value="Enviar" class="btn btn-primary" id="button-1"/>
</form>
</div>
</body>
</html>