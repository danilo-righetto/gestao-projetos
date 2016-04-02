<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(function() {
		// 		$("#menu-projetos").attr('class', 'active');
		$("#tbTarefas").dataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : true,
			"bInfo" : false,
			"bAutoWidth" : true,
			"language" : {
				"emptyTable" : "Nenhuma informação cadastrada",
				"search" : "Pesquisar:",
				"paginate" : {
					"first" : "Primeira",
					"last" : "Última",
					"next" : "Próximo",
					"previous" : "Anterior"
				}
			}
		});
	});

	function concluirTarefa(idTarefa, descricao){
		$("#bodyConcluir p").remove();
		$("#bodyConcluir").append("<p>Deseja realmente concluir a tarefa "+idTarefa+" - "+descricao+"?</p>");
		$("#idtarefa").val(idTarefa);
		$("#modalConcluirTarefa").modal({
			keyboard : false,
			backdrop : 'static'
		});
	}
</script>
</head>
<body>
	<!-- MODAL CONCLUIR TAREFA INICIO -->
	<div class="modal fade" id="modalConcluirTarefa" tabindex="-1"
		role="dialog" data-backdrop="static" aria-labelledby="myModalLabel">
		<form action='<c:url value="/painel/projetos/concluirTarefa" />'>
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Concluir Tarefa</h4>
					</div>
					<div class="modal-body" id="bodyConcluir">
						<p></p>
						<input type="hidden" id="idtarefa" name="idTarefa">
					</div>
					<div class="modal-footer">
						<button type="button"
							style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<input type="submit"
							style="background-color: #4DC1FF; color: #fff; border-color: #4DC1FF"
							class="btn btn-default" value="Concluir">
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- MODAL CONCLUIR TAREFA FIM -->
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Tarefas</h4>
			<div id="alertas"></div>
			<table class="table table-responsive" id="tbTarefas">
				<thead>
					<tr class="text-center">
						<td><span style="font-weight: bold;">#</span></td>
						<td><span style="font-weight: bold;">Descrição Tarefa</span></td>
						<td><span style="font-weight: bold;">Responsável</span></td>
						<td><span style="font-weight: bold;">Data Início</span></td>
						<td><span style="font-weight: bold;">Previsão Término</span></td>
						<td><span style="font-weight: bold;">Status</span></td>
						<td><span style="font-weight: bold;">Ação</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty tarefas}">
							<c:forEach items="${tarefas}" var="tarefa">
								<tr class="text-center">
									<td>${tarefa.id}</td>
									<td>${tarefa.descricao}</td>
									<td>${tarefa.responsavel.nome}</td>
									<td><fmt:formatDate value="${tarefa.dataInicio.time}"
											pattern="dd/MM/yyyy"></fmt:formatDate></td>
									<td><fmt:formatDate value="${tarefa.previsaoTermino.time}"
											pattern="dd/MM/yyyy"></fmt:formatDate></td>
									<td>${tarefa.status}</td>
									<td><a style="margin-left: 10px"
										href='<c:url value="/painel/projetos/${tarefa.projeto.id}/tarefas/${tarefa.id}/editar"></c:url>'
										title="Editar"> <span class="glyphicon glyphicon-pencil">
										</span></a> <c:if test="${tarefa.status ne 'Concluido' }">
											<a style="margin-left: 10px;"
												onclick="concluirTarefa(${tarefa.id},'${tarefa.descricao}');"
												href="#" title="Concluir Tarefa"> <span
												class="glyphicon glyphicon-play-circle"> </span></a>
										</c:if>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6">Não há dados a serem exibidos</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<br /> <a
				href='<c:url value="/painel/projetos/${idProjeto}/tarefas/cadastro"></c:url>'
				class="btn btn-default btn-add">Nova Tarefa</a>
		</div>
	</div>
</body>
</html>