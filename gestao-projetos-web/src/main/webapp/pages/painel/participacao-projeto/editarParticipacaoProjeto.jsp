<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edição de Participação Projeto</title>
</head>
<body>
	<form
		action='<c:url value="/painel/participacao-projetos/editarParticipacaoProjeto"></c:url>'
		method="POST">
		<!-- Formulario de Edição - INICIO -->
		<div class="section">
			<div class="container">
				<h3 class="title-screen">Edição de Participação Projeto</h3>
				<hr />
				<div class="col-md-12">
					<div class="col-md-offset-3">
						<div>
							<input id="idProjeto" name="idProjeto" value="${idProjeto}"
								type="hidden" />
						</div>
						<div class="form-group col-md-4">
							<label for="parceiro">Parceiro:</label> <input
								id="parceiro" name="razaosocial" class="form-control"
								value="${parceiro.razaosocial}" required autofocus />
							<!-- MONTAR MODAL
								<option value="" label="Selecione..." />
								<c:forEach var="parceiro" items="${parceirosDaUnidade}">
									<option value="${parceiro.id}"
										label="${parceiro.razaosocial}" />
								</c:forEach>
								 -->
						</div>
						<div class="form-group col-md-4" id="coordenadores">
							<label for="coordenador">Coordenador:</label> <select
								id="coordenador" name="idCoordenador" class="form-control"
								required autofocus
								onchange="listarReeducandos(), listarColaboradores();">
								<option value="" label="" />
							</select>
						</div>
					</div>
				</div>
				<!-- Formulario de Cadastro - FIM -->
				<br />
				<h4 class="title-screen" id="titleReeducandos">Reeducandos</h4>
				<table class="table table-responsive" id="reeducandos">
					<thead>
						<tr class="text-center">
							<td></td>
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Matrícula</span></td>
							<td><span style="font-weight: bold;">Nome</span></td>
							<td><span style="font-weight: bold;">Sexo</span></td>
							<td><span style="font-weight: bold;">Função</span></td>
						</tr>
					</thead>
					<tbody id="tbody-reeducandos">
					</tbody>
				</table>
				<br />
				<h4 class="title-screen" id="titleColaboradores">Colaboradores</h4>
				<table class="table table-responsive" id="colaboradores">
					<thead>
						<tr class="text-center">
							<td></td>
							<td><span style="font-weight: bold;">#</span></td>
							<td><span style="font-weight: bold;">Nome</span></td>
							<td><span style="font-weight: bold;">Usuário</span></td>
						</tr>
					</thead>
					<tbody id="tbody-colaboradores">
					</tbody>
				</table>
				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-default btn-add">Salvar</button>
						<a href='<c:url value="/painel/projetos/"></c:url>'
							class="btn btn-default btn-return">Cancelar</a>
					</div>
				</div>
			</div>
		</div>



	</form>
</body>
</html>