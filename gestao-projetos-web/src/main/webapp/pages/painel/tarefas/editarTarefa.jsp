<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<div class="row">
				<h4 class="title-screen">Editar Tarefa</h4>
				<hr />
				<div class="row col-md-12">
					<form
						action='<c:url value="/painel/projetos/tarefas/editarTarefa"></c:url>'
						method="POST">
						<div class="row">
							<input id="idProjeto" name="projeto.id" value="${idProjeto}"
								type="hidden" /> <input id="idTarefa" name="id"
								value="${tarefa.id}" type="hidden" />
							<div class="form-group col-md-4">
								<label for="descricao">Descrição:</label><input
									class="form-control" id="descricao" name="descricao"
									value="${tarefa.descricao}" required autofocus />
							</div>
							<div class="form-group col-md-4">
								<label for="responsavel">Responsável:</label><select
									class="form-control" id="responsavel" name="responsavel.id"
									required>
									<c:forEach var="usuario" items="${associados}">
										<c:choose>
											<c:when test="${tarefa.responsavel.id == usuario.id}">
												<option value="${usuario.id}" label="${usuario.nome}"
													selected />
											</c:when>
											<c:otherwise>
												<option value="${usuario.id}" label="${usuario.nome}" />
												<option value="" label="NÃO DEFINIDO" />
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-2">
								<label for="dataInicio">Data Inicio:</label><input
									class="form-control data" id="dataInicio" name="dataInicio"
									value='<fmt:formatDate value="${tarefa.dataInicio.time}"/>'
									required />
							</div>
							<div class="form-group col-md-2">
								<label for="previsaoTermino">Previsão Término:</label><input
									class="form-control data" id="previsaoTermino"
									name="previsaoTermino"
									value='<fmt:formatDate value="${tarefa.previsaoTermino.time}"/>'
									required />
							</div>
						</div>
						<div style="margin-top: 50px;">
							<hr />
							<a class="btn btn-default btn-return"
								href='<c:url value="/painel/projetos/${idProjeto}/tarefas"></c:url>'><span
								class="glyphicon glyphicon-remove"></span>Cancelar</a>
							<button class="btn btn-default btn-add" type="submit">
								<span class="glyphicon glyphicon-ok"></span>Cadastrar Tarefa
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="section" style="margin-top: 224px"></div>
</body>
</html>