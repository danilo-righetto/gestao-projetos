<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
	$(function() {
		// 	$("#menu-acoes").attr('class', 'active');
		$(".data").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior'
				});
	});
</script>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Cadastrar Tarefa</h4>
			<div class="row">
				<form action="salvarTarefa" method="POST">
					<div class="row col-md-12">
						<input id="idProjeto" name="projeto.id" value="${idProjeto}"
							type="hidden" />
						<div class="form-group col-md-4">
							<label for="descricao">Descrição:</label><input
								class="form-control" id="descricao" name="descricao"
								placeholder="Descrição da tarefa" required autofocus />
						</div>
						<div class="form-group col-md-4">
							<label for="responsavel">Responsável:</label><select
								class="form-control" id="responsavel" name="responsavel.id"
								required>
								<option value="" label="Selecione..." />
								<c:forEach var="usuario" items="${associados}">
									<option value="${usuario.id}" label="${usuario.nome}" />
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row col-md-12">
						<div class="form-group col-md-3">
							<label for="status">Status:</label><select class="form-control"
								id="status" name="status" required>
								<option value="" label="Selecione..." />
								<option value="Aberto">ABERTO</option>
								<option value="Em andamento">EM ANDAMENTO</option>
								<option value="Encerrado">ENCERRADO</option>
								<option value="Concluido">CONCLUIDO</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="dataInicio">Data Inicio:</label><input
								class="form-control data" id="dataInicio" name="dataInicio"
								required />
						</div>
						<div class="form-group col-md-3">
							<label for="previsao">Previsão Término:</label><input
								class="form-control data" id="previsao" name="previsao" required />
						</div>
						<div class="form-group col-md-3">
							<label for="dataTermino">Data Término:</label><input
								class="form-control data" id="dataTermino" name="dataTermino"
								required />
						</div>
					</div>
					<div>
						<a class="btn btn-default btn-return"
							href='<c:url value="/painel/projetos"></c:url>'><span
							class="glyphicon glyphicon-remove"></span>Cancelar</a>
						<button class="btn btn-default btn-add" type="submit">
							<span class="glyphicon glyphicon-ok"></span>Cadastrar Tarefa
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>