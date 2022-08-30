<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Cadastro de Projeto</h1>
<c:if test="${param.descricao!=null }">
	<c:out value="O projeto ${param.descricao} foi cadastrado com sucesso!" />	
</c:if>
<form action="/adiciona-projeto" method="post">
<input type="text" name="descricao" width=30 placeholder="Nome do Projeto"><br />
<input type="text" name="responsavel" width=30 placeholder="Responsavel pelo projeto"><br />
<label for="tipoContagem">Tipo de Contagem:</label>
<select name="tipoContagem">
	<option value="Detalhada">Detalhada</option>
	<option value="Estimada">Estimada</option>
</select>
<br />
<label for="tipoProjeto">Tipo de projeto:</label>
<select name="tipoProjeto">
	<option value="aplicação">Aplicação</option>
	<option value="Desenvolvimento">Desenvolvimento</option>
	<option value="Melhoria">Melhoria</option>
</select>
<br />
<label for="artefato">Artefatos da análise:</label><br />
<textarea rows="5" cols="30" name="artefato"></textarea><br />
<label for="comentarios">Comentarios:</label><br />
<textarea rows="5" cols="30" name="comentarios"></textarea><br />
<input type="date" name="dataInicio" width=30 placeholder="Digite a data de inicio"><br />
<input type="submit" value="Enviar" id="button-1"/>
</form>
</body>
</html>