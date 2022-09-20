<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<title>Detalhes da Funcionalidade</title>
</head>
<body>	
		<!-- INCLUI MENU CABEÇALHO -->
		<tag:menu></tag:menu>
		<div class="container">
		<h1>Alterar Função</h1>
			<form action=<c:out value="/alterar-funcao/${funcao.getProjeto().getId()}" /> method="post">
				<div class="form-group">
				<label for="descricao" class="form-label">Descrição:</label>
				<input type="text" name="descricao" value="${funcao.getDescricao()}" placeholder="Descrição"
					class="form-control">
					</div><br />
					 
				
				<div class="form-group">
				<label for="Responsavel" class="form-label">Responsável:</label>
				<input type="text" value="${funcao.getResponsavel()}" name="Responsavel" class="form-control"
					placeholder="Responsavel pela tarefa">
				</div><br />
				
				<div class="form-group">
				<label for="rlr_alr" class="form-label">RLR_ALR:</label>	
				<input	type="text" class="form-control" value="${funcao.getRlr_alr()}" name="rlr_alr" width=3
					placeholder="Quantidade de RLR/ALR"></div><br> 
					
				<div class="form-group">
				<label for="der" class="form-label">Der:</label>	
				<input type="text" value="${funcao.getDer()}" name="der" placeholder="Quantidade de DER" class="form-control"></div><br />

				<input type="hidden" name="id" value="${funcao.getId()}"
					class="form-control" />				

				<div class="form-group">
					<label for="idDeflator" class="form-label">Tipo de Função:</label>
					<select name="idDeflator" class="form-select">
						<c:forEach var="deflator" items="${deflatores}">
							<option value="${deflator.getId()}" <c:out value="${funcao.getDeflator().getId()==deflator.getId() ? 'selected' : null}" />>${deflator.getDescricao()}</option>
						</c:forEach>
					</select></div><br />	
					<div class="form-group">
					<label for="status" class="form-label">Status:</label>
					<select name="status" class="form-select">
						<option value="Pendente" <c:out value="${funcao.getStatus().equals('Pendente') ? 'selected' : null}" />>Pendente</option>
						<option value="Concluido" <c:out value="${funcao.getStatus().equals('Concluido') ? 'selected' : null}" />>Concluido</option>
					</select><br />	
				<c:if test="${funcao.getStatus().equals('Concluido')}">
				<div class="form-group">
				<label for="dataConclusao" class="form-label">Data Conclusão:</label>	
				<input type="date" value="${funcao.getDataConclusaoFormatada()}" name="dataConclusao" placeholder="Data da Conclusão" class="form-control">
				</div>
				</c:if>
				<br />	
									
				</div>
				<br />
				<button type="submit" class="btn btn-primary">Salvar</button>
				<a href="/excluir-funcao/${funcao.getProjeto().getId()}/${funcao.getId()}" class="btn btn-danger"><img src="/lixeira-de-reciclagem.png" />Excluir Funcionalidade</img></a>
			</form>
		</div>
	</div>
</body>
</html>