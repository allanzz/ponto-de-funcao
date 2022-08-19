<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de categoria</title>
</head>
<body>
<h1>Cadastro de Categoria</h1>
<c:if test="${param.nome!=null }">
	<c:out value="A categoria foi cadastrada com sucesso!" />	
</c:if>
<form action="/adiciona-categoria" method="post">
<input type="text" name="descricao" width=70 placeholder="Titulo da categoria">
<input type="text" name="PontoDeFuncao" width=70 placeholder="Quantidade pontos de função">
<input type="submit" value="Enviar" id="button-1"/>
</form>
</body>
</html>