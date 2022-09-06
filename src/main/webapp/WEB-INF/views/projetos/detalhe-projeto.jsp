<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<title>Cadastro de projeto</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="CadastroNovaFuncionalidade" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Cadastro nova
						funcionalidade</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action=<c:out value="/nova-funcao/${projeto.getId()}" />
						method="post">

						<input type="text" name="descricao" placeholder="Descrição"
							class="form-control"><br /> <input type="text"
							name="Responsavel" class="form-control"
							placeholder="Responsavel pela tarefa"><br /> <input
							type="text" class="form-control" name="rlr_alr" width=3
							placeholder="Quantidade de RLR/ALR"></br> <input type="text"
							name="der" placeholder="Quantidade de DER" class="form-control"><br />
						<input type="hidden" name="projeto_id" value="${projeto.getId()}"
							class="form-control" />
						<div class="form-group">
							<label for="tipoDeFuncao" class="form-label">Tipo de
								Função:</label> <select name=tipoDeFuncao class="form-select">
								<option value="ArquivoInterfaceExterna">AIE</option>
								<option value="ArquivoLogicoInterno">ALI</option>
								<option value="EntradaExterna">EE</option>
								<option value="SaidaExterna">SE</option>
								<option value="ConsultaExterna">CE</option>
							</select><br />
						</div>
						<div class="form-group">
							<label for="idDeflator" class="form-label">Tipo de
								Função:</label> <select name="idDeflator" class="form-select">
								<c:forEach var="deflator" items="${deflatores}">
									<option value="${deflator.getId()}">${deflator.getDescricao()}</option>
								</c:forEach>
							</select><br />
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<tag:menu></tag:menu>
	<div class="container">

		<div class="container-fluid">
			<h1><c:out value="${projeto.getDescricao()}" /></h1>
			<fmt:formatDate value="${projeto.getDataInicio()}" type="both" pattern="dd/MM/yyyy" var="dataFormatada" /><br />
			<c:out value="Responsável:${projeto.getResponsavel()}" /><br />
			<c:out value="Data de Inicio:${dataFormatada}" /><br />
		</div><br/>
		<c:set var="total" value="0" />
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#CadastroNovaFuncionalidade">Cadastrar nova
			funcionalidade</button>

		</div>
		<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Descrição</th>
					<th scope="col">Responsável</th>
					<th scope="col">Categoria</th>
					<th scope="col">RLR/ALR</th>
					<th scope="col">DER</th>
					<th scope="col">Complexidade</th>
					<th scope="col">PF</th>
					<th scope="col">Deflator</th>
					<th scope="col">PF-I</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="funcao" items="${projeto.getFuncoes()}">
					<tr>
						<td>${funcao.getDescricao()}</td>
						<td>${funcao.getResponsavel()}</td>
						<td>${funcao.getTipo()}</td>
						<td>${funcao.getRlr()}</td>
						<td>${funcao.getDer()}</td>
						<td>${funcao.getPontosDeFuncao()}</td>
						<td>${funcao.calcularPontosDeFuncao()}</td>
						<td>${funcao.getDeflator().getValor()}</td>
						<td>${funcao.getPontoDeFuncaoImpactado()}</td>
						<c:set var="total" value="${total+funcao.getPontosDeFuncao()}" />
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:out value=" Total de Pontos: ${total}" />
	</div>
</body>
</html>